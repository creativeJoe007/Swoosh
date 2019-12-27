package joe.creative.swoosh.Controllers

import android.content.Intent
import android.os.Bundle
import joe.creative.swoosh.R
import android.view.View
import android.widget.Toast
import joe.creative.swoosh.Utilities.EXTRA_LEAGUE
import joe.creative.swoosh.Utilities.SKILL_LEVEL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    var league: String? = ""
    var skillLevel: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    fun ballerClicked(view: View) {
        if(!ballerBtn.isChecked) skillLevel = ""
        else {
            beginnerBtn.isChecked = false

            skillLevel = "baller"
        }
    }

    fun beginnerClicked(view: View) {
        if(!beginnerBtn.isChecked) skillLevel = ""
        else {
            ballerBtn.isChecked = false

            skillLevel = "beginner"
        }
    }

    fun finishCLicked(view: View) {
        println(skillLevel)
        if(skillLevel != "" && skillLevel !== null) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(SKILL_LEVEL, skillLevel)
            finishActivity.putExtra(EXTRA_LEAGUE, league)

            startActivity(finishActivity)
        }
        else {
            Toast.makeText(this, "Please select a skill", Toast.LENGTH_SHORT)
                .show()
        }

    }
}
