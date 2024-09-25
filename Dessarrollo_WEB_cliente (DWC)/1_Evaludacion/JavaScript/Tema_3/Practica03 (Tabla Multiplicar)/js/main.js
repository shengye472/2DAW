for (let a = 1; a <= 9; a++) {
    for (let i = 1; i <= 10; i++) {
        document.getElementById("table").innerHTML +=
            `<tr>
        <td>${a} x ${i}</td>
        <td>${a * i}</td>
    </tr>`;
    }
}