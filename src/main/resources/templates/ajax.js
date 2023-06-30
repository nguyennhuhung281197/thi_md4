function showListCity() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/city",
        success(data){
            let list = ``;
            list += `<table border="1px">
<tr>
                <td>Tên Thành Phố</td>
                <td>Quốc Gia</td>
                <td>Diện Tích</td>
                <td>Dân Số</td>
                <td>GDP</td>
                <td>Mô Tả</td>
            </tr>`
            for (let i = 0 ; i < data.length ; i++) {
                list += `<tr>
            <td>${data[i].tenThanhPho}</td>
            <td>${data[i].quocGia.ten}</td>
            <td>${data[i].dienTich}</td>
            <td>${data[i].danSo}</td>
            <td>${data[i].gdp}</td>
            <td>${data[i].mota}</td>
            <td><button onclick="view(${data[i].id})">View</button></td>
<td><button onclick="deleteById(${data[i].id})">Delete</button></td>
<td><button onclick="showFormUpdate(${data[i].id})">Update</button> </td>
        </tr>`
            }
            list += `</table>`
            document.getElementById("display").innerHTML = list;
            console.log(list)
        }
    })
}

function createListPicture() {
    let form = ``
    form += `<table><tr>
<td>Picture Name</td>
<td><input type="text" id="tenThanhPho"></td>
</tr>

<tr>
<td>Quốc Gia</td>
<td><select id="quocGia"></select></td>
</tr>
<tr>

<tr>
<td>Width</td>
<td><input type="text" id="dienTich"></td>
</tr>
<tr>
<td>Material</td>
<td><input type="text" id="danSo"></td>
</tr>
<tr>
<td>Description</td>
<td><input type="text" id="gdp"></td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" id="mota"></td>
</tr>

<td><button onclick="addPicture()">Add</button></td>
</tr>
</table>`
    document.getElementById("display").innerHTML = form;

    $.ajax({
        "type": "GET",
        "url": "http://localhost:8080/category",
        success(data) {
            let text = ``
            for (let i = 0; i < data.length; i++) {
                text += `<option value="${data[i].id}">${data[i].ten}</option>`
            }
            document.getElementById("quocGia").innerHTML = text;
        }
    })
}

function addPicture() {
    let tenThanhPho = $('#tenThanhPho').val();
    let quocGia = $("#quocGia").val()
    let id = quocGia[0]
    let quocGiaName = quocGia[1]
    let categories = [{id, quocGiaName}]
    let dienTich = $('#dienTich').val();
    let danSo = $('#danSo').val();
    let gdp = $('#gdp').val();
    let mota = $('#mota').val();

    let newPicture = {
        tenThanhPho: tenThanhPho,
        quocGia: categories ,
        dienTich: dienTich,
        danSo: danSo,
        gdp: gdp,
        mota: mota
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newPicture),
        url: "http://localhost:8080/city",
        success() {
            showListCity();
        }
    });
}

function deleteById(id) {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/city/" + id,
        success() {
            showListCity()
        }
    });
}

function showFormUpdate(id) {
    $.ajax({
        type: "patch",
        url: "http://localhost:8080/city/" + id,
        success(data) {
            let context = ``
            context += `<table>
<tr>
<td>Name</td>
<td><input type="text" value="${data.name}" id="name"></td>
</tr>
<tr>
<td>Number</td>
<td><input type="text" value="${data.number}" id="number"></td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" value="${data.price}" id="price"></td>
</tr>
<tr>
<td>Status</td>
<td><input type="text" value="${data.status}" id="status"></td>
</tr>
<tr>
<td><select id="category"></select></td>
</tr>
<tr><td><button onclick="update(${data.id})">Add</button></td></tr>
</table>`
            document.getElementById("display").innerHTML = context;
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/category",
                success(arr) {
                    let text = ``
                    for (let i = 0; i < arr.length; i++) {
                        text += `<option value="${arr[i].id}">${arr[i].name}</option>`
                    }
                    document.getElementById("category").innerHTML = text
                }
            })
        }
    })

}

function update(id) {
    let name = $('#name').val()
    let number = $('#number').val()
    let price = $('#price').val()
    let status = $('#status').val()
    let cate = document.getElementById("category").value
    let newProduct = {
        name: name,
        number: number,
        price: price,
        status: status,
        category: {
            "id": cate
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "PUT",
        url: "http://localhost:8080/city/" + id,
        data: JSON.stringify(newProduct),
        success() {
            showListCity()
        }
    });
    event.defaultPrevented
}