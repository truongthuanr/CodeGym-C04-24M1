class course {
    name;
    listStudents;

    constructor(courseName){
        this.name = courseName;
        this.listStudents = [];

    }

    readLocalStorage(local){
        this.listStudents = this.listStudents.concat(local.listStudents)
    }

    addStudent(newStudent){
        console.log("Run course.addStuden")
        let temp = JSON.stringify(newStudent)
        temp = JSON.parse(temp)
        this.listStudents.push(temp)

        showAll()
    }

    removeStudent(i){
        console.log(`Run remove student index ${i}`)
        this.listStudents.splice(i)

    }

    getStudent(){

    }
    
    updateStudent(){

    }

    

}