
const path = "http://35.242.191.29:8888/SoloProject/api/";

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
    createPromise("GET", path + "User/findAllUsers").then(resolve => { console.log(resolve) });
}

function getUser() {
    let getId = Number(document.getElementById('find').value);

    createPromise("GET", path + "User/findAUserId/" + getId).then(resolve => { console.log(resolve) });
}

function createUser() {

    if (document.getElementById('password').value == document.getElementById('passcon').value) {

        let user = {
            username: document.getElementById('username').value,
            password: document.getElementById('password').value,
            email: document.getElementById('email').value
        };

        console.log(user);

        createPromise("POST", path + "User/createUser", JSON.stringify(user)).then(resolve => { console.log(resolve) });

        createPromise("GET", path + "User/findAUserNameExact/" + user.username).then(value => {
            let data = JSON.parse(value);

            console.log(data.uId);

            sessionStorage.setItem('userLogin', data.uId);

            window.location.href = 'ownaccount.html';
        })


    } else {

        document.getElementById("errorpass").innerText = "Passwords Dont Match"
    }

}

function deleteUser() {

    let delId = sessionStorage.getItem("userLogin");
    createPromise("DELETE", path + "User/deleteUser/" + delId).then(resolve => { console.log(resolve) });
    sessionStorage.removeItem("userLogin");

    window.location.href = 'index.html';
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

        createPromise("PUT", path + "User/updateUser/" + user.uId, JSON.stringify(user)).then(resolve => { console.log(resolve) });
        window.location.href = 'ownaccount.html';
    } else {
        document.getElementById('errormess').innerText = "Entered password or email does not match, please try again"
    }
}

function login() {

    let username = document.getElementById("logname").value;

    createPromise("GET", path + "User/findAUserNameExact/" + username).then(value => {
        let data = JSON.parse(value);

        console.log(data[0].uId);

        if (data[0].password == document.getElementById("logpass").value) {

            sessionStorage.setItem('userLogin', data[0].uId);

            window.location.href = 'ownaccount.html';
        } else {
            document.getElementById("errorpass").innerText = "Entered username/password is incorrect"
        }

    });

}