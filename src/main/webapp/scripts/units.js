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


function getAllUnits() {
    createPromise("GET", path + "Unit/getAllUnits").then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('unitTable');
        console.log(data[4]);
        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (let j = tableSize; j > 1; j--) {
                container.deleteRow(j - 1);
            }
        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myName = document.createElement('td');
            myName.innerHTML = data[i].name;
            let myrarity = document.createElement('td');
            if (data[i].rarity == 1) {
                myrarity.innerHTML = "N";
            } else if (data[i].rarity == 2) {
                myrarity.innerHTML = "R";
            } else if (data[i].rarity == 3) {
                myrarity.innerHTML = "SR";
            } else if (data[i].rarity == 4) {
                myrarity.innerHTML = "SSR";
            } else if (data[i].rarity == 5) {
                myrarity.innerHTML = "UR";
            } else if (data[i].rarity == 6) {
                myrarity.innerHTML = "TUR";
            } else if (data[i].rarity == 7) {
                myrarity.innerHTML = "LR";
            } else {
                myrarity.innerHTML = "EZA";
            }

            let mytype = document.createElement('td');

            if (data[i].type == 1) {
                mytype.innerHTML = "STR";
            } else if (data[i].type == 2) {
                mytype.innerHTML = "PHY";
            } else if (data[i].type == 3) {
                mytype.innerHTML = "INT";
            } else if (data[i].type == 4) {
                mytype.innerHTML = "TEQ";
            } else {
                mytype.innerHTML = "AGL";
            }

            let myalignment = document.createElement('td');
            myalignment.innerHTML = data[i].alignment;
            let myhp = document.createElement('td');
            myhp.innerHTML = data[i].hp;
            let myatk = document.createElement('td');
            myatk.innerHTML = data[i].atk;
            let mydef = document.createElement('td');
            mydef.innerHTML = data[i].def;

            myRow.appendChild(myName);
            myRow.appendChild(myrarity);
            myRow.appendChild(mytype);
            myRow.appendChild(myalignment);
            myRow.appendChild(myhp);
            myRow.appendChild(myatk);
            myRow.appendChild(mydef);

            let detail = document.createElement('td');
            let detailButton = document.createElement('button');

            detailButton.id = data[i].cId;
            detailButton.innerText = "Add to Storage";
            detailButton.onclick = detailButtonHandler;
            detail.innerHTML = detailButton;

            myRow.appendChild(detailButton);

        }
    })
        .catch((error) => console.log(error.message));
    return false;
}

const detailButtonHandler = () => {

    let check = sessionStorage.getItem('userLogin')

    if (check != null) {

        createPromise("POST", path + "Storage/createStorage/" + check + "/" + event.target.id).then(resolve => {
            console.log(resolve)
        })

    } else {
        document.getElementById("errolog").innerText = "Please log in to add units to your storage";
    }

}

function filterTable() {

    let name = document.getElementById('searchName').value;

    createPromise("GET", path + "Unit/getUnitName/" + name).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('unitTable');
        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (let k = tableSize; k > 1; k--) {
                container.deleteRow(k - 1);
            }
        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myName = document.createElement('td');
            myName.innerHTML = data[i].name;
            let myrarity = document.createElement('td');
            if (data[i].rarity == 1) {
                myrarity.innerHTML = "N";
            } else if (data[i].rarity == 2) {
                myrarity.innerHTML = "R";
            } else if (data[i].rarity == 3) {
                myrarity.innerHTML = "SR";
            } else if (data[i].rarity == 4) {
                myrarity.innerHTML = "SSR";
            } else if (data[i].rarity == 5) {
                myrarity.innerHTML = "UR";
            } else if (data[i].rarity == 6) {
                myrarity.innerHTML = "TUR";
            } else if (data[i].rarity == 7) {
                myrarity.innerHTML = "LR";
            } else {
                myrarity.innerHTML = "EZA";
            }

            let mytype = document.createElement('td');

            if (data[i].type == 1) {
                mytype.innerHTML = "STR";
            } else if (data[i].type == 2) {
                mytype.innerHTML = "PHY";
            } else if (data[i].type == 3) {
                mytype.innerHTML = "INT";
            } else if (data[i].type == 4) {
                mytype.innerHTML = "TEQ";
            } else {
                mytype.innerHTML = "AGL";
            }

            let myalignment = document.createElement('td');
            myalignment.innerHTML = data[i].alignment;
            let myhp = document.createElement('td');
            myhp.innerHTML = data[i].hp;
            let myatk = document.createElement('td');
            myatk.innerHTML = data[i].atk;
            let mydef = document.createElement('td');
            mydef.innerHTML = data[i].def;

            myRow.appendChild(myName);
            myRow.appendChild(myrarity);
            myRow.appendChild(mytype);
            myRow.appendChild(myalignment);
            myRow.appendChild(myhp);
            myRow.appendChild(myatk);
            myRow.appendChild(mydef);

            let detail = document.createElement('td');
            let detailButton = document.createElement('button');

            detailButton.id = value[i].memberid;
            detailButton.innerText = "Add to Storage";
            detailButton.onclick = detailButtonHandler;
            detail.innerHTML = detailButton;

            myRow.appendChild(detailButton);

        }
    })
        .catch((error) => console.log(error.message));
    return false;
}

function ftype() {
    var path2 = "Unit/getUnitType/";
    if (document.getElementById("searchType").value == "str") {
        let type = 1;
        filter(path2, type);
    } else if (document.getElementById("searchType").value == "phy") {
        let type = 2;
        filter(path2, type);
    } else if (document.getElementById("searchType").value == "int") {
        let type = 3;
        filter(path2, type);
    } else if (document.getElementById("searchType").value == "teq") {
        let type = 4;
        filter(path2, type);
    } else if (document.getElementById("searchType").value == "agl") {
        let type = 5;
        filter(path2, type);
    } else {
        document.getElementById("errolog").innerText = "Incorrect entry";
    }

}

function filter(path2, type) {

    createPromise("GET", path + path2 + type).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('unitTable');
        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (let j = tableSize; j > 1; j--) {
                container.deleteRow(j - 1);
            }
        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myName = document.createElement('td');
            myName.innerHTML = data[i].name;
            let myrarity = document.createElement('td');
            if (data[i].rarity == 1) {
                myrarity.innerHTML = "N";
            } else if (data[i].rarity == 2) {
                myrarity.innerHTML = "R";
            } else if (data[i].rarity == 3) {
                myrarity.innerHTML = "SR";
            } else if (data[i].rarity == 4) {
                myrarity.innerHTML = "SSR";
            } else if (data[i].rarity == 5) {
                myrarity.innerHTML = "UR";
            } else if (data[i].rarity == 6) {
                myrarity.innerHTML = "TUR";
            } else if (data[i].rarity == 7) {
                myrarity.innerHTML = "LR";
            } else {
                myrarity.innerHTML = "EZA";
            }

            let mytype = document.createElement('td');

            if (data[i].type == 1) {
                mytype.innerHTML = "STR";
            } else if (data[i].type == 2) {
                mytype.innerHTML = "PHY";
            } else if (data[i].type == 3) {
                mytype.innerHTML = "INT";
            } else if (data[i].type == 4) {
                mytype.innerHTML = "TEQ";
            } else {
                mytype.innerHTML = "AGL";
            }

            let myalignment = document.createElement('td');
            myalignment.innerHTML = data[i].alignment;
            let myhp = document.createElement('td');
            myhp.innerHTML = data[i].hp;
            let myatk = document.createElement('td');
            myatk.innerHTML = data[i].atk;
            let mydef = document.createElement('td');
            mydef.innerHTML = data[i].def;

            myRow.appendChild(myName);
            myRow.appendChild(myrarity);
            myRow.appendChild(mytype);
            myRow.appendChild(myalignment);
            myRow.appendChild(myhp);
            myRow.appendChild(myatk);
            myRow.appendChild(mydef);

            let detail = document.createElement('td');
            let detailButton = document.createElement('button');

            detailButton.id = value[i].memberid;
            detailButton.innerText = "Add to Storage";
            detailButton.onclick = detailButtonHandler;
            detail.innerHTML = detailButton;

            myRow.appendChild(detailButton);

        }
    })
        .catch((error) => console.log(error.message));
    return false;
}

function rarity() {
    var path2 = "Unit/getUnitRarity/";

    if (document.getElementById("searchRarity").value == "N") {
        let type = 1;
        filter(path2, type);
    } else if (document.getElementById("searchRarity").value == "R") {
        let type = 2;
        filter(path2, type);
    } else if (document.getElementById("searchRarity").value == "SR") {
        let type = 3;
        filter(path2, type);
    } else if (document.getElementById("searchRarity").value == "SSR") {
        let type = 4;
        filter(path2, type);
    } else if (document.getElementById("searchRarity").value == "UR") {
        let type = 5;
        filter(path2, type);
    } else if (document.getElementById("searchRarity").value == "TUR") {
        let type = 6;
        filter(path2, type);
    } else if (document.getElementById("searchRarity").value == "LR") {
        let type = 7;
        filter(path2, type);
    } else if (document.getElementById("searchRarity").value == "EZA") {
        let type = 8;
        filter(path2, type);
    } else {
        document.getElementById("errolog").innerText = "Incorrect entry";
    }
}