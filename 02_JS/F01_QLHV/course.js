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
        console.log("Run course.addStudent")
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
    
    updateStudent(i,student){
        console.log("Run course.updateStudent");
        let temp = JSON.stringify(student);
        temp = JSON.parse(temp);
        this.listStudents[i] = temp;

        showAll();




    }

    

}