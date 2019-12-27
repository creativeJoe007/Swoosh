package joe.creative.swoosh.Controllers

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import joe.creative.swoosh.Utilities.EXTRA_LEAGUE
import joe.creative.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var selectedLeague: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueBtnClicked(view: View) {
        if(!selectedLeague.isEmpty()) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        }
        else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun onMenClicked(view: View) {
        if(!mensLeagueBtn.isChecked) selectedLeague = ""
        else {
            womensLeagueBtn.isChecked = false
            coEdLeagueBtn.isChecked = false

            selectedLeague = "Men"
        }
    }

    fun onWomenClicked(view: View) {
        if(!womensLeagueBtn.isChecked) selectedLeague = ""
        else {
            coEdLeagueBtn.isChecked = false
            mensLeagueBtn.isChecked = false

            selectedLeague = "Women"
        }
    }

    fun onCoedClicked(view: View) {
        if(!coEdLeagueBtn.isChecked) selectedLeague = ""
        else {
            womensLeagueBtn.isChecked = false
            mensLeagueBtn.isChecked = false

            selectedLeague = "Coed"
        }
    }
}
