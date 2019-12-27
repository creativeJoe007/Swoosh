package joe.creative.swoosh.Controllers

import joe.creative.swoosh.R
import android.os.Bundle
import joe.creative.swoosh.Models.Player
import joe.creative.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {
    private var generatedText: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        generatedText = "Looking for a ${player.league?.toLowerCase()} ${player.skill?.toLowerCase()} league near you"
        userMessage.text = generatedText
    }
}
