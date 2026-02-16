function showemployee(){
    fetch("http://localhost:8080/employees")
    .then((response) => response.json())
    .then((employeedetails) => {
        const dataTable = document.getElementById("employeeDetails")

        employeedetails.forEach(employeedetails => {
            var row = `<tr>
            <td>${employeedetails.id}</td>
            <td>${employeedetails.name}</td>
            <td>${employeedetails.age}</td>
            <td>${employeedetails.gender}</td>
            <td>${employeedetails.employeeroll}</td>
            <td>${employeedetails.salary}</td>
          
            </tr>`;

            dataTable.innerHTML+=row;
        });
    })
    .catch(error => console.error('Error fetching electives:', error));
}

function showemployeetask(){
    fetch("http://localhost:8080/employees/task") 
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
