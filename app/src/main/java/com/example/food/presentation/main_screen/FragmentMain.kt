package com.example.food.presentation.main_screen

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.food.R
import com.example.food.databinding.FragmentMainBinding
import com.example.food.domain.models.Recipe
import com.example.food.domain.models.User
import com.example.food.presentation.main_screen.recycler_view.food_category.FoodCategoryAdapter
import com.example.food.presentation.main_screen.recycler_view.listeners.RecipeOnClickListeners
import com.example.food.presentation.main_screen.recycler_view.recipe.RecipeAdapter
import com.example.food.presentation.main_screen.view_pager.ViewPagerAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FragmentMain : Fragment() , RecipeOnClickListeners {
    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }
    private val viewModel: FragmentMainViewModel by viewModels()
    private val viewPagerAdapter:ViewPagerAdapter by lazy {
        ViewPagerAdapter()
    }
    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter(this)
    }
    private val foodCategoryAdapter: FoodCategoryAdapter by lazy {
        FoodCategoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setupSearchView()
        observeData()
    }
    private fun setupSearchView(){
        binding.mainContent.searchView.setupSearchViewParams()
    }
    private fun observeData(){
        viewModel.uiStateFlow.onEach {uiState ->
            viewPagerAdapter.updateData(uiState.recommendationsEvents)
            recipeAdapter.updateData(uiState.recipes)
            foodCategoryAdapter.updateData(uiState.foodCategories)
            showUserInfo(uiState.currentUser)
        }.launchIn(lifecycleScope)

    }
    private fun showUserInfo(user: User){
        Glide.with(requireActivity())
            .load(user.avatarUrl)
            .into(binding.mainTopContent.avatarImageView)
    }
    private fun initViews() = with(binding){
        binding.mainContent.viewPager.adapter = viewPagerAdapter
        binding.mainContent.recyclerView.adapter = recipeAdapter
        binding.mainContent.foodCategoryRecyclerView.adapter = foodCategoryAdapter
    }

    override fun onRecipeClick(recipe: Recipe) {
        findNavController().navigate(FragmentMainDirections.actionFragmentMainToFragmentRecipeDetails(recipe))
    }
}
fun SearchView.setupSearchViewParams() {
    val searchText = this.findViewById<View>(
        this.context.resources.getIdentifier(
            "android:id/search_src_text",
            null,
            null
        )
    ) as AutoCompleteTextView
    searchText.setTextSize(
        TypedValue.COMPLEX_UNIT_PX,
        resources.getDimensionPixelSize(R.dimen.textSizeForSmallTexts).toFloat()
    )
    val typeface = ResourcesCompat.getFont(this.context, R.font.inter_light)
    searchText.typeface = typeface
}