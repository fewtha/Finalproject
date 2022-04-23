package th.ac.kku.nkc.cis.mobile.myproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var newArrayList: ArrayList<News>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var listSong:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId= arrayOf(
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6,
            R.drawable.user7,
            R.drawable.user8,
        )
        heading= arrayOf(
            "BODYSLAM",
            "POTATO",
            "LABANOON",
            "POLYCAT",
            "INK WARUNTORN",
            "POP PONGKUL",
            "MAHAFATHER",
            "FIN",
        )
        listSong= arrayOf(
                    //Bodyslam
                    "ชีวิตเป็นของเรา\n" +
                    "ขอบฟ้า\n" +
                    "ความรักทำให้คนตาบอด\n" +
                    "ความเชื่อ\n" +
                    "พูดในใจ\n",

                    //potato
                     "ไม่ให้เธอไป\n" +
                    "ชู้ บี ดู วับ\n" +
                    "ผู้ชายขี้กลัว\n" +
                    "ไม่เป็นไรเกรงใจ\n" +
                    "กล้าพอไหม\n",
                    //labanoon
                    "ยาม\n" +
                    "หนักใจ\n" +
                    "Help me Please\n" +
                    "อมยิ้ม\n" +
                    "ความรู้สึก\n",
                    //polycat
                    "ภักดี \n" +
                    "เพื่อนไม่จริง\n" +
                    "เวลาเธอยิ้ม\n" +
                    "มันเป็นใคร \n" +
                    "เธอคงยังไม่ \n",
                    //INK WARUNTORN
                    "สายตาหลอกกันไม่ได้ \n" +
                    "อยากเริ่มต้นใหม่กับคนเดิม\n" +
                    "ลบไม่ได้ช่วยให้ลืม\n" +
                    "รอหรือพอ\n" +
                    "ดีใจด้วยนะ \n",
                    //POP PONGKUL
                    "ภาพจำ\n" +
                    "ระหว่างที่รอเขา\n" +
                    "ระยะทำใจ\n" +
                    "พรุ่งนี้ค่อย\n" +
                    "จืด\n",
                    //MAHAFATHER
                    "ร้ายๆ\n" +
                    "ขอฉันขอ\n" +
                    "ภาพทรงจำ\n" +
                    "เธอไม่ควรต้องเสียใจ\n" +
                    "แค่อ่อนไหว\n",

                    "ร้ายๆ\n" +
                    "ขอฉันขอ\n" +
                    "ภาพทรงจำ\n" +
                    "เธอไม่ควรต้องเสียใจ\n" +
                    "แค่อ่อนไหว\n",
        )
        newRecyclerView=findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<News>()

        getUserData()
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            var news = News(imageId[i], heading[i] , listSong[i])
            newArrayList.add(news)
        }

        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(
//                    this@MainActivity,
//                    "คุณคลิกเลือ item ลำดับที่. $position",
//                    Toast.LENGTH_SHORT
//                ).show()
                var intent = Intent(this@MainActivity,SongActivity::class.java)

                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("imageID",newArrayList[position].titleImage)
                intent.putExtra("listSong",newArrayList[position].listSong)

                startActivity(intent)
            }
        })
        FirebaseAuth.getInstance().signOut()
    }
}