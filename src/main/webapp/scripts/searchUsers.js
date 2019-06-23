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


function displayUsers() {
    createPromise("GET", path + "User/findAllUsers").then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('userTable');
        console.log(data[4]);
        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }
        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);

            let myName = document.createElement('td');
            myName.innerHTML = data[i].username;
            myRow.appendChild(myName);


            let detail = document.createElement('td');
            let detailButton = document.createElement('button');
            detailButton.id = data[i].uId;
            detailButton.innerText = "View User";
            detailButton.onclick = detailButtonHandler;
            detail.innerHTML = detailButton;

            myRow.appendChild(detailButton);

        }
    })
        .catch((error) => console.log(error.message));
    return false;
}

const detailButtonHandler = () => {


    sessionStorage.setItem('searchedUserId', event.target.id);

    console.log(event.target.id);

    window.location.href = 'foreignUser.html';

    let gdfs = sessionStorage.getItem("searchedUserId");


}

function filterTable() {

    let search =  document.getElementById('searchName').value;
    

console.log(search);

    createPromise("GET", path + "User/findAUserName/" + search).then(value => {
        let data = JSON.parse(value);
        const container = document.getElementById('userTable');
        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }
        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);

            let myName = document.createElement('td');
            myName.innerHTML = data[i].username;
            myRow.appendChild(myName);


            let detail = document.createElement('td');
            let detailButton = document.createElement('button');
            detailButton.id = data[i].uId;
            detailButton.innerText = "View User";
            detailButton.onclick = detailButtonHandler;
            detail.innerHTML = detailButton;

            myRow.appendChild(detailButton);

        }
    })
        .catch((error) => console.log(error.message));
    return false;
}

