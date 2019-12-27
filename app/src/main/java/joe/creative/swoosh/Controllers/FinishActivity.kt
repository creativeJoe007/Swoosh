package joe.creative.swoosh.Controllers

import joe.creative.swoosh.R
import android.os.Bundle
import joe.creative.swoosh.Utilities.EXTRA_LEAGUE
import joe.creative.swoosh.Utilities.SKILL_LEVEL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {
    private var selectedLeague: String? = ""
    private var skillLevel: String? = ""
    private var generatedText: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        selectedLeague = intent.getStringExtra(EXTRA_LEAGUE)
        skillLevel = intent.getStringExtra(SKILL_LEVEL)

        generatedText = "Looking for a ${selectedLeague?.toLowerCase()} ${skillLevel?.toLowerCase()} league near you"
        userMessage.text = generatedText
    }
}
