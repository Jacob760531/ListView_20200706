package kr.co.tjoeun.listview_20200706

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.listview_20200706.adapters.StudentAdapter
import kr.co.tjoeun.listview_20200706.datas.Student

class MainActivity : AppCompatActivity() {

//    학생목록을 담고 있는 변수
    val mStudentList  = ArrayList<Student>()

    lateinit var mAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        미뤄둔 어댑터 객체화를 실행
        mAdapter = StudentAdapter(this, R.layout.student_list_item,mStudentList)

//        완성된 어댑터를 리스트뷰와 연결
        studentListView.adapter = mAdapter

//        어댑터를 먼저 연결하고, 내용물 추가
        mStudentList.add(Student("조장우","종로구",1983))
        mStudentList.add(Student("홍길동","동대문구",1990))
        mStudentList.add(Student("우뢰매","성북구",1998))
        mStudentList.add(Student("해리슨포드","강남구",1966))

//        어댑터에게 새로고침 시키기
        mAdapter.notifyDataSetChanged()

//        학생 목록 리스트뷰의 이벤트 철
        studentListView.setOnItemClickListener { parent, view, position, id ->

//            각 줄을 누르면 눌린 사람의 이름을 토스트로

//            눌린 사람이 누군지
            val clickedUser = mStudentList[position]

//          토스트로 눌린사람 이름
            Toast.makeText(this, clickedUser.name, Toast.LENGTH_SHORT).show()
        }


        //        학생 목록 롱클릭 이벤트 처리
        studentListView.setOnItemLongClickListener { parent, view, position, id ->


//            오래 눌린 사람을 명단에서 삭제
            mStudentList.removeAt(position)

//            어댑터에게 새로고침 시키기
            mAdapter.notifyDataSetChanged()

//            LongClick은 BooLean 값을 리턴해 줘야함
            return@setOnItemLongClickListener true
        }

    }
}
