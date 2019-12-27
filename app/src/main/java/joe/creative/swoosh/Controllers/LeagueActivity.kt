package joe.creative.swoosh.Controllers

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import joe.creative.swoosh.Models.Player
import joe.creative.swoosh.Utilities.EXTRA_PLAYER
import joe.creative.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var player: Player = Player("", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueBtnClicked(view: View) {
        if(player.league != "" && player.league !== null) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        }
        else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun onMenClicked(view: View) {
        if(!mensLeagueBtn.isChecked) player.league = ""
        else {
            womensLeagueBtn.isChecked = false
            coEdLeagueBtn.isChecked = false

            player.league = "Men"
        }
    }

    fun onWomenClicked(view: View) {
        if(!womensLeagueBtn.isChecked) player.league = ""
        else {
            coEdLeagueBtn.isChecked = false
            mensLeagueBtn.isChecked = false

            player.league = "Women"
        }
    }

    fun onCoedClicked(view: View) {
        if(!coEdLeagueBtn.isChecked) player.league = ""
        else {
            womensLeagueBtn.isChecked = false
            mensLeagueBtn.isChecked = false

            player.league = "Coed"
        }
    }
}
