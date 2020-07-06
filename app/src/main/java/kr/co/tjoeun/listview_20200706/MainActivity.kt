package kr.co.tjoeun.listview_20200706

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.tjoeun.listview_20200706.datas.Student

class MainActivity : AppCompatActivity() {

//    학생목록을 담고 있는 변수
    val mStudentList  = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조장우","종로구",1983))
        mStudentList.add(Student("홍길동","동대문구",1990))
        mStudentList.add(Student("우뢰매","성북구",1998))
        mStudentList.add(Student("해리슨포드","강남구",1966))

    }
}
