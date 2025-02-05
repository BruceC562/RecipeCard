package com.example.recipecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.recipecard.ui.theme.RecipeCardTheme
import androidx.compose.ui.text.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeCardTheme {
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        RecipeCard()
                    }
                }
            }
        }
    }
}

@Composable
fun RecipeCard() {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(top = 0.dp, end = 10.dp, start = 10.dp),
        colors = CardDefaults.cardColors()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Classic French\nCrème Caramel",
                fontSize = 45.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp),
                style = TextStyle(lineHeight = 1.em)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.creme_caramel_2),
                    contentDescription = "https://www.madaboutmacarons.com/classic-french-creme-caramel/",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .aspectRatio(1.77f), // Aspect ratio written by Gemini
                    contentScale = ContentScale.FillWidth
                )
                Text(
                    text = "Recipe by Jill Colonna from her website: Mad about Macarons",
                    textAlign = TextAlign.Center
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "Ingredients:",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
                IngredientList()
                Text(
                    text = "Instructions:",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Instructions()
            }
        }
    }
}

@Composable
fun IngredientList() {
    val caramelIngredients = listOf("100 g granulated sugar", "3 tablespoon water")
    val custardIngredients = listOf("500 ml whole milk", "1 vanilla pod/bean", "2 large eggs", "3 egg yolks", "70 g sugar")
    Text(
        text = "Caramel",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    HorizontalDivider(thickness = 2.dp, color = Color.Black)
    for (ingredient in caramelIngredients) {
        Text(text = ingredient, fontSize = 15.sp)
        HorizontalDivider(thickness = 2.dp)
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Text(
        text = "Custard Cream",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    HorizontalDivider(thickness = 2.dp, color = Color.Black)
    for (ingredient in custardIngredients) {
        Text(text = ingredient)
        HorizontalDivider(thickness = 2.dp)
    }
}

@Composable
fun Instructions() {
    val instructions = listOf(
        "Put the granulated sugar and water in a small saucepan. Shake the pan first to half dissolve the sugar in the water. " +
                "Then, over a medium-high heat, leave the caramel to form without stirring. This should take about 10 minutes. " +
                "Swirl it around a bit and wait until the caramel is medium to dark brown.",
        "Pour the amber caramel into a large dish, ensuring that it coats completely the base.  Set aside to cool so that the caramel sets.",
        "Preheat the oven to 170°C/340°F.  Split the vanilla pod down the middle if using. Pour the milk into a medium saucepan, adding the vanilla and " +
                "just allow the milk to heat to simmering point (not boiling). Cover and take off the heat to cool slightly and remove the vanilla pod.",
        "Whisk the eggs, yolks and sugar vigorously in a medium bowl until paler.\n" +
                "Pour in the WARM vanilla milk and whisk gently just until combined. Leave to rest for a minute to let the foam subside.",
        "Place the large dish into a large roasting tin lined with baking paper. Pour the warm thin custard over the caramel, filling near to the top.\n" +
                "Place the roasting tin in the middle of the oven and pour in warm-hot water around the ramekins or dish so that it comes to about half or ⅔ of the way up.",
        "Bake for about 40 minutes or until set. Remove from the oven carefully, and after 10 minutes, gradually remove the ramekins onto a cooling rack. " +
                "When cool, transfer to the fridge and chill for at least 2 hours - ideally overnight."
    )
    Column {
        for (i in 0..instructions.size - 1) {
            Row(
                modifier = Modifier.padding(bottom = 4.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "${i + 1}.",
                    fontSize = 12.sp,
                    style = TextStyle(lineHeight = 1.5.em),
                    modifier = Modifier.padding(end = 5.dp, top = 0.dp)
                )
                Text(
                    text = instructions[i],
                    fontSize = 12.sp,
                    style = TextStyle(lineHeight = 1.5.em),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeCardPreview() {
    RecipeCardTheme {
        RecipeCard()
    }
}