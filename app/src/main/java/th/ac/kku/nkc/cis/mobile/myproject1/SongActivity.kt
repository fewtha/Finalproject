package th.ac.kku.nkc.cis.mobile.myproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)

        val fullname : TextView=findViewById(R.id.nameUser)
        val imageUser : ImageView =findViewById(R.id.profile_image)
        val listsong   : TextView=findViewById(R.id.listId)

        val bundle:Bundle?= intent.extras

        val heading = bundle!!.getString("heading")
        val imageID = bundle.getInt("imageID")
        val listSong= bundle!!.getString("listsong")

        fullname.text=heading
        listsong.text=listSong
        imageUser.setImageResource(imageID)

    }
}