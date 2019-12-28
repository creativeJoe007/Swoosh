package joe.creative.swoosh.Controllers

import android.content.Intent
import android.os.Bundle
import joe.creative.swoosh.R
import android.view.View
import android.widget.Toast
import joe.creative.swoosh.Models.Player
import joe.creative.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    lateinit var player : Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER) ?: player;
    }

    fun ballerClicked(view: View) {
        if(!ballerBtn.isChecked) player.skill = ""
        else {
            beginnerBtn.isChecked = false

            player.skill = "baller"
        }
    }

    fun beginnerClicked(view: View) {
        if(!beginnerBtn.isChecked) player.skill = ""
        else {
            ballerBtn.isChecked = false

            player.skill = "beginner"
        }
    }

    fun finishCLicked(view: View) {
        if(player.skill != "" && player.skill !== null) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)

            startActivity(finishActivity)
        }
        else {
            Toast.makeText(this, "Please select a skill", Toast.LENGTH_SHORT)
                .show()
        }

    }
}
