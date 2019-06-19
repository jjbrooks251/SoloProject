
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

    createPromise("GET", "http://35.198.82.58:8888/SoloProject/api/User/findAllUsers").then(resolve => { console.log(resolve) });

}

function getUser() {

    let getId = Number(document.getElementById('find').value);

    createPromise("GET", "http://35.198.82.58:8888/SoloProject/api/User/findAUserId/" + getId).then(resolve => { console.log(resolve) });

}


function createUser() {
    let user = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        email: document.getElementById('email').value
    };


    createPromise("POST", "http://35.198.82.58:8888/SoloProject/api/User/createUser/", JSON.stringify(user)).then(resolve => { console.log(resolve) });
}

function deleteUser() {

    let delId = Number(document.getElementById('delete').value);
    createPromise("DELETE", "http://35.198.82.58:8888/SoloProject/api/User/deleteUser/" + delId).then(resolve => { console.log(resolve) });
}


function updateUser() {

    let user = {
        uId: Number(document.getElementById('id').value),
        username: document.getElementById('upuser').value,
        password: document.getElementById('uppass').value,
        email: document.getElementById('upemail').value
    };

    createPromise("PUT", "http://35.198.82.58:8888/SoloProject/api/User/updateUser/" + user.uId, JSON.stringify(user)).then(resolve => { console.log(resolve) });
}
