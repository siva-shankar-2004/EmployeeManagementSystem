function showelectives(){
    fetch("http://localhost:8080/employees")
    .then((response) => response.json())
    .then((electives) => {
        const dataTable = document.getElementById("employeDetails")

        electives.forEach(elective => {
            var row = `<tr>
            <td>${employeedetails.id}</td>
            <td>${employeedetails.id}</td>
            <td>${employeedetails.id}</td>
            <td>${employeedetails.id}</td>
            <td>${employeedetails.id}</td>
            <td>${employeedetails.id}</td>
          
            </tr>`;

            dataTable.innerHTML+=row;
        });
    })
    .catch(error => console.error('Error fetching electives:', error));
}

function showEnrolledStudents(){
    fetch("http://localhost:8080/elective/reisterd") 
    .then((response) => response.json()) 
    .then((students) => {
        const dataTable = document.getElementById("enrolledStudent")
            
        students.forEach(student => {
            var row = `<tr>
            <td>${student.rollno}</td>
            <td>${student.name}</td>
            <td>${student.emailid}</td>
            <td>${student.electivename}</td>
            </tr>`;

            dataTable.innerHTML+=row;
            
        })
        .catch(error => console.error('Error fetching electives:', error));
    });
}
