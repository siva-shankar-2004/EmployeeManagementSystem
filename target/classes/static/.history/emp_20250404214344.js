function showemployee() {
    fetch("http://localhost:8080/employees")
        .then((response) => response.json())
        .then((employees) => {
            const dataTable = document.getElementById("employeeDetails");
            dataTable.innerHTML = ""; // Clear previous data

            employees.forEach(employee => {
                const row = `
                    <tr>
                        <td>${employee.id}</td>
                        <td><input type="text" id="name-${employee.id}" value="${employee.name}"></td>
                        <td><input type="number" id="age-${employee.id}" value="${employee.age}"></td>
                        <td><input type="text" id="gender-${employee.id}" value="${employee.gender}"></td>
                        <td><input type="text" id="roll-${employee.id}" value="${employee.employeeroll}"></td>
                        <td><input type="text" id="salary-${employee.id}" value="${employee.salary}"></td>
                        <td>
                            <button class="edit-btn" onclick="updateEmployee('${employee.id}')">Update</button>
                            <button class="delete-btn" onclick="deleteEmployee('${employee.id}')">Delete</button>
                        </td>
                    </tr>`;
                dataTable.innerHTML += row;
            });
        })
        .catch(error => console.error('Error fetching employees:', error));
}

function updateEmployee(id) {
    const name = document.getElementById(`name-${id}`).value;
    const age = document.getElementById(`age-${id}`).value;
    const gender = document.getElementById(`gender-${id}`).value;
    const employeeroll = document.getElementById(`roll-${id}`).value;
    const salary = document.getElementById(`salary-${id}`).value;

    const params = new URLSearchParams({
        name,
        age,
        gender,
        employeeroll,
        salary
    });

    fetch(`http://localhost:8080/employees/${id}?${params.toString()}`, {
        method: 'PUT'
    })
    .then(response => {
        if (response.ok) {
            alert("Employee updated successfully!");
            showemployee();
        } else {
            alert("Failed to update employee.");
        }
    });
}

function deleteEmployee(id) {
    fetch(`http://localhost:8080/employees/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            alert("Employee deleted successfully!");
            showemployee();
        } else {
            alert("Failed to delete employee.");
        }
    });
}
