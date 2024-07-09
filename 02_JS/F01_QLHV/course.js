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

        // console.log(`Map id ${this.listStudents.find(a => a.id).id}`)
        // console.log(`Map id ${this.listStudents.find(s => s.id === temp.id)}`)
        // console.log(`Map id ${ === undefined}`)


        if(this.listStudents.find(s => s.id == temp.id) === undefined ){
            this.listStudents.push(temp)
            alert("Add Successfully")
            hideAll()
            showAll()            
        }
        else {
            alert("ID Existed!")
        }

        

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
        alert("Update Successfully")

        showAll();




    }

    

}