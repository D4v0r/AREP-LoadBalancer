let app = (() => {
    const PATH = "/messages";
    let index = 1;
    return{
        getMessages(){
            let tableBody = $("#tableBody");
            tableBody.empty();
            axios.get(PATH).then(res => {
                res.data.forEach(({content, date})=>{
                    tableBody.append(
                        `<tr>
                                <td>${index}</td>
                                <td>${content}</td>
                                <td>${date}</td>
                         </tr>`
                    );
                    index += 1;
                });
            });
        },
        addMessage(){
            let messageContent = $("#content").val();
            axios.post(PATH, {"content" : messageContent, "date" : " "})
                .then(response => this.getMessages());
        },
    }
})();