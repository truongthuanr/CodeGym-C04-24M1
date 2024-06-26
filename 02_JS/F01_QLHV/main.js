// let stu1 = new Student(1, "Nguyen Truong Thuan", "01/01/2000", "Nam", "nguyentruongthuan@gmail.com")
// let stu2 = new Student(2, "Ho Ngoc Ha", "02/02/2002", "Nữ", "ngocha@gmail.com")
// let stu3 = new Student(3, "Tran Van Thanh", "03/03/2001", "Nam", "vanthanhtran@gmail.com")
// myCourse.addStudent(stu1)
// myCourse.addStudent(stu2)
// myCourse.addStudent(stu3)

// localStorage.setItem('myCourse',JSON.stringify(myCourse))
// console.log(localStorage.getItem('myCourse'))

let local = JSON.parse(localStorage.getItem("myCourse"))
console.log(local.listStudents)

let myCourse = new course("Javascript Course")
myCourse.readLocalStorage(local)
console.log(myCourse.listStudents)


// coursetemp = JSON.stringify(myCourse.listStudents)
// coursetemp = JSON.parse(coursetemp)
// console.log(coursetemp)
// console.log(myCourse.listStudents)
// let temp = local.listStudents || []
// temp = temp.concat(coursetemp)
// console.log(temp)

// console.log(`Local storage ${local.}`)
// local.addStudent()

showAll()

console.log("asdfasfasdf")

// avoid resubmitsion form
if (window.history.replaceState) {
    window.history.replaceState(null, null, window.location.href);
}


let newstudent_form = document.getElementById('addnewstudent-form')
newstudent_form.addEventListener("submit", submitNewStudent)

document.getElementById('editprofile-form').addEventListener("submit", updateprofile)
document.getElementById('newprofile-form').addEventListener("submit", submitNewStudent)


function addNewStudent() {
    hideAll()
    document.getElementById('newprofile').style.display = 'block'
}

function showDetail(i) {
    console.log('Run showDetail()')
    let studentdetail = document.getElementById('studentdetail')
    console.log(myCourse.listStudents[i])
    let student = myCourse.listStudents[i]
    // studentdetail.innerHTML = myCourse.listStudents[i].name

    console.log(studentdetail.querySelector('name'))
    hideAll()
    studentdetail.style.display = "block"

    let str = `
    <img src="hacker.png" class="rounded mx-auto d-block" alt="..."
                     style="width: 200px ;height: 200px; border: 5px solid black;">
                    <dl class="row text-start">
                        <dt class="col-sm-4">Photo</dt>
                        <dd class="col-sm-7" id="name">${student.photo}</dd>
                        <dt class="col-sm-4">Name</dt>
                        <dd class="col-sm-7" id="name">${student.name}</dd>

                        <dt class="col-sm-4">Birthday</dt>
                        <dd class="col-sm-7">${student.birthday}</dd>
                        
                        <dt class="col-sm-4">Gender</dt>
                        <dd class="col-sm-7">${student.gender}</dd>
                        
                        <dt class="col-sm-4">Email</dt>
                        <dd class="col-sm-7">${student.email}</dd>
                        <dt class="col-sm-2"></dt>

                        <dd class="col-sm-7">
                        <div class="d-grid gap-2" id="" style="width:200px">
                            <button class="btn btn-info" onclick="editprofile(${i})">Edit</button>
                        </div>
                        
                        </dd>
                    </dl>
                        `
    studentdetail.innerHTML = str
}

function submitNewStudent(event) {
    console.log('Submit new student form')



    // let newstudent = newstudent_form.elements
    let newstudent_form = document.getElementById('newprofile-form')
    let valid = false;


    // Form validation
    // console.log(`New student ID ${newstudent_form.elements.namedItem('student-id').value}`)
    // console.log(`New student Name ${newstudent_form.elements.namedItem('student-name').value}`)
    // console.log(`New student Birthday ${newstudent_form.elements.namedItem('student-birthday').value}`)
    let studentid = newstudent_form.elements.namedItem('newprofileid').value;
    let studentname = newstudent_form.elements.namedItem('newprofilename').value;
    let studentbirthday = newstudent_form.elements.namedItem('newprofilebirthday').value
    let studentgender = document.querySelector('input[type=radio][name=newprofile-gender]:checked').value
    let studentemail = newstudent_form.elements.namedItem('newprofileemail').value

    let studentcourse = newstudent_form.elements.namedItem('newprofilecourse').value


    valid = newProfileValidate(studentid,studentname,studentbirthday,studentemail)



    if (valid == true) {
        let student = new Student(studentid,
            studentname,
            studentbirthday,
            studentgender,
            studentemail,
            studentcourse)

        myCourse.addStudent(student)

    }
    // Add student 
    // console.log(`New student form length ${newstudent_form.elements.namedItem('name').value}`)
    event.preventDefault();
    return true
}

function newProfileValidate(studentid,studentname,studentbirthday,studentemail){
    if (studentid == "") {
        alert("Student's ID must be not-null")
    }
    else if (studentname == "") {
        alert("Student's Name must be not-null")

    }
    else if (studentbirthday == "") {
        alert("Student's Name must be not-null")
    }
    else if (studentemail === null) {
        alert("Student's Email must be not-null")
    }
    else {
        return true;
    }
    return false
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
            <td>${list[i].email}</td>
            <td><div class="btn-group" role="group" aria-label="Basic mixed styles example">
  <button type="button" class="btn btn-success" onclick="showDetail(${i})">Detail</button>
  <button type="button" class="btn btn-danger" onclick="remove(${i})">Remove</button>
</div></td>


        </tr>
        `

        // <td><button onclick="showDetail(${i})">Detail</button>
        //         <button onclick="remove(${i})">Remove</button></td>
        // <td>${list[i].email}</td>
        //     <td><button onclick="showFormEdit(${i})">Sửa</button></td>
        //     <td><button onclick="remove(${i})">Xóa</button></td>
    }
    document.getElementById('table-student').innerHTML = str
}


function SaveToStorage() {
    localStorage.setItem('myCourse', JSON.stringify(myCourse))
    // newstudent_form.reset();
    // newstudent_form.style.display = 'None'
}

function remove(i) {
    myCourse.removeStudent(i)
    showAll()
}

function editprofile(i) {
    console.log('Run editprofile()')
    let student = myCourse.listStudents[i]
    // let studentdetail = document.getElementById('studentdetail')
    hideAll()
    let editprofileform = document.getElementById('editprofile')
    editprofileform.style.display = 'block';
    document.getElementById('editid').value = student.id;
    document.getElementById('editname').value = student.name;
    document.getElementById('editbirthday').value = student.birthday;
    document.getElementById('editemail').value = student.email;

    document.getElementById('editcourse').value = student.course;
    document.getElementById(`edit-gender-${student.gender.toLowerCase()}`).checked = true;

    str = `<button type="submit" class="btn btn-primary" id="submit-edit-btn" value=${i}>Update</button>`
    console.log(str)
    document.getElementById('submit-edit-btn-div').innerHTML = str






}

function hideAll() {
    document.getElementById('studentdetail').style.display = 'none'
    document.getElementById('editprofile').style.display = 'none'
    document.getElementById('newprofile').style.display = 'none'



}


function updateprofile(event) {
    let i = document.getElementById('submit-edit-btn').value;
    console.log(`Run updateprofile ${i}`)

    let editprofileform = document.getElementById('editprofile-form')
    let studentid = editprofileform.elements.namedItem('editid').value;
    let studentname = editprofileform.elements.namedItem('editname').value;
    let studentbirthday = editprofileform.elements.namedItem('editbirthday').value
    let studentgender = document.querySelector('input[type=radio][name=edit-gender]:checked').value
    let studentemail = editprofileform.elements.namedItem('editemail').value
    let studentcourse = editprofileform.elements.namedItem('editcourse').value

    valid = editvalidate(studentname, studentbirthday, studentemail)
    if (valid == true) {
        console.log(`Valid to update profile`)
        let student = new Student(studentid,
            studentname,
            studentbirthday,
            studentgender,
            studentemail,
            studentcourse)
        
            myCourse.updateStudent(i,student)

    }




    event.preventDefault();
    return true

}


function editvalidate(studentname, studentbirthday, studentemail) {
    console.log(`Run editvalidate`)
    if (studentname == "") {
        alert("Student's Name must be not-null")
    }
    else if (studentbirthday == "") {
        alert("Student's Name must be not-null")
    }
    else if (studentemail == "") {
        alert("Student's Email must be not-null")
    }


    else {
        return true;
    }
    return false;
}


function doSearch(){
    hideAll();

}