
const pathloc = "http://localhost:8080/SoloProject/api/";
const pathser = "http://35.198.82.58:8888/SoloProject/api/";

function createPromise(method, url, body) {
    return new Promise(function (resolve, reject) {

        let req = new XMLHttpRequest();

        req.open(method, url);
        req.send(body);
        req.onload = function () {
            if (req.status === 200) {
                resolve(req.response);
            } else {
                reject(Error(req.statusText));
            }
        };

        req.onerror = function () {
            reject(Error("Network Error"))
        };

    })

}

function getAllUsers() {
    createPromise("GET", pathloc + "User/findAllUsers").then(resolve => { console.log(resolve) });
}

function getUser() {
    let getId = Number(document.getElementById('find').value);

    createPromise("GET", pathloc + "User/findAUserId/" + getId).then(resolve => { console.log(resolve) });
}

function createUser() {

    if (document.getElementById('password').value == document.getElementById('passcon').value) {

        let user = {
            username: document.getElementById('username').value,
            password: document.getElementById('password').value,
            email: document.getElementById('email').value
        };

        console.log(user);

        createPromise("POST", pathloc + "User/createUser", JSON.stringify(user)).then(resolve => { console.log(resolve) });

        window.location.href = 'index.html';

    } else {

        console.log("passwords dont match");
    }

}

function deleteUser() {

    let delId = sessionStorage.getItem("userLogin");
    createPromise("DELETE", pathloc + "User/deleteUser/" + delId).then(resolve => { console.log(resolve) });
    sessionStorage.removeItem("userLogin");
}

function updateUser() {

    if (document.getElementById('uppass').value == document.getElementById('conuppass').value && document.getElementById('upemail').value == document.getElementById('conupemail').value) {

        let user = {
            uId: sessionStorage.getItem('userLogin'),
            username: document.getElementById('upuser').value,
            password: document.getElementById('uppass').value,
            email: document.getElementById('upemail').value
        }

        console.log(user);

        createPromise("PUT", pathloc + "User/updateUser/" + user.uId, JSON.stringify(user)).then(resolve => { console.log(resolve) });
        window.location.href = 'ownaccount.html';
    } else {
        document.getElementById('errormess').innerText = "Entered password or email does not match, please try again"
    }
}

function login() {

    let username = document.getElementById("logname").value;

    createPromise("GET", pathloc + "User/findAUserNameExact/" + username).then(value => {
        let data = JSON.parse(value);

        console.log(data[0].uId);

        sessionStorage.setItem('userLogin', data[0].uId);

        window.location.href = 'ownaccount.html';

    });

}