// myCourse = new course("Javascript Course")



// let stu1 = new Student(1, "Nguyen Truong Thuan", "01/01/2000", "Nam", "nguyentruongthuan@gmail.com")
// let stu2 = new Student(2, "Ho Ngoc Ha", "02/02/2002", "Nữ", "ngocha@gmail.com")
// let stu3 = new Student(3, "Tran Van Thanh", "03/03/2001", "Nam", "vanthanhtran@gmail.com")
// myCourse.addStudent(stu1)
// myCourse.addStudent(stu2)
// myCourse.addStudent(stu3)

// localStorage.setItem('myCourse',JSON.stringify(myCourse))
// console.log(localStorage.getItem('myCourse'))

myCourse = JSON.parse(localStorage.getItem("myCourse"))

showAll()

console.log("asdfasfasdf")

// avoid resubmitsion form
if ( window.history.replaceState ) {
    window.history.replaceState( null, null, window.location.href );
  }


let newstudent_form = document.getElementById('addnewstudent-form')
newstudent_form.addEventListener("submit",submitNewStudent)

function addNewStudent() {
    document.getElementById('addnewstudent-form').style.display = 'block'
}

function showDetail() {

}

function submitNewStudent(event){
    console.log('Submit new student form')



    let newstudent = newstudent_form.elements


    // Form validation
    console.log(`New student ID ${newstudent_form.elements.namedItem('student-id').value}`)
    console.log(`New student Name ${newstudent_form.elements.namedItem('student-name').value}`)
    console.log(`New student Birthday ${newstudent_form.elements.namedItem('student-birthday').value}`)
    let gender = document.querySelector('input[type=radio][name=student-gender]:checked')
    console.log(`Gender ${gender}`)

    if (newstudent.namedItem('student-id').value==""){
        alert("Student's ID must be not-null")
    }
    else if (newstudent.namedItem('student-name').value==""){
        alert("Student's Name must be not-null")

    }
    else if (newstudent.namedItem('student-birthday').value==""){
        alert("Student's Name must be not-null")
    }
    else if (gender===null){
        alert("Student's Gender must be not-null")
    }
    else if()


    // Add student 
    // console.log(`New student form length ${newstudent_form.elements.namedItem('name').value}`)
    event.preventDefault();

    return true

}

function showAll() {
    console.log("ShowAll")
    list = myCourse.listStudents
    let str = `
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>

        <th colspan="2">Action</th>
    </tr>
`
    console.log(`List length: ${list.length}`)
    for (let i = 0; i < list.length; i++) {
        console.log(list[i])

        str += `
        <tr>
            <td>${list[i].id}</td>
            <td>${list[i].name}</td>
            

            <td><button onclick="showDetail(${i})">Chi tiết</button></td>

        </tr>
        `
        // <td>${list[i].email}</td>
        //     <td><button onclick="showFormEdit(${i})">Sửa</button></td>
        //     <td><button onclick="remove(${i})">Xóa</button></td>
    }
    document.getElementById('table-student').innerHTML = str
}