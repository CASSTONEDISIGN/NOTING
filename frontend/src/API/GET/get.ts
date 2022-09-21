import axios from "axios";

const BASE_URL = "https://jsonplaceholder.typicode.com/";

export default {
    getArticle: function(id) {
        return axios.get(BASE_URL + `posts/${id}`);
    }
}