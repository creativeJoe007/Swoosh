package joe.creative.swoosh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        womensLeagueBtn.isChecked = false
        coEdLeagueBtn.isChecked = false

        selectedLeague = "Men"
    }

    fun onWomenClicked(view: View) {
        coEdLeagueBtn.isChecked = false
        mensLeagueBtn.isChecked = false

        selectedLeague = "Women"
    }

    fun onCoedClicked(view: View) {
        womensLeagueBtn.isChecked = false
        mensLeagueBtn.isChecked = false

        selectedLeague = "Coed"
    }
}
