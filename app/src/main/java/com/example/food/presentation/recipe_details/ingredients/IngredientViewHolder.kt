
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food.databinding.ItemIngredientBinding
import com.example.food.domain.models.Ingredient

class IngredientViewHolder(
    private val binding: ItemIngredientBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ingredient: Ingredient) = with(binding) {
        ingredientTitleTextView.text = ingredient.title
        val count = "${ingredient.count}${ingredient.countType}"
        ingredientCountTextView.text = count
        loadImageByUrl(
            imageUrl = ingredient.imageUrl,
            imageView = ingredientImageView
        )
    }

    private fun loadImageByUrl(imageUrl: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}