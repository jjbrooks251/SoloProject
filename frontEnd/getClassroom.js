function getClassroom() {

    let getId = Number(document.getElementById('find').value);

    let req = new XMLHttpRequest();

    req.onload = function () { console.log(req.responseText) }

    req.open("GET", "http://localhost:8080/SoloProject/api/User/findAUserId/" + getId);

    req.send();

}

function getAllUsers() {

    let req = new XMLHttpRequest();

    req.onload = function () { console.log(req.responseText) }

    req.open("GET", "http://localhost:8080/SoloProject/api/User/findAllUsers");

    req.send();

}

function createUser() {
    let user = {
        uId: 6,
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        email: document.getElementById('email').value
    };


    let req = new XMLHttpRequest();

    req.onload = function () { console.log(req.responseText) }

    req.open("POST", "http://localhost:8080/SoloProject/api/User/createUser/");

    req.send(JSON.stringify(user));


}

function deleteUser() {

    let req = new XMLHttpRequest();

    req.onload = function () {console.log(req.responseText) }

    let delId = 5;

    req.open("DELETE", "http://localhost:8080/SoloProject/api/User/deleteUser/" + delId);

    req.send();

}

 
function updateUser(){

let req = new XMLHttpRequest();

req.onload = function () { console.log(req.responseText) }

    let upId = 5;

    req.open("PUT", "http://localhost:8080/SoloProject/api/User/updateUser/" + upId);

    req.send();

}