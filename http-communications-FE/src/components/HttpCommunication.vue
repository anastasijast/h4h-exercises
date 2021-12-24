<template>
  <div>
    <h1>
      Spring boot skeleton application without DB Connectivity
    </h1>
    <hr class="grayBorder" style="margin-bottom: 40px;width:40%">
    <div class="flex spaceBetween">
       <div class="flex">
        <h3 class="margin-right">List of users</h3>
        <button 
          class="btn"
          @click="getListOfUsers"
        >
          Get list of users
        </button>
      </div>


      <form @submit.prevent="addUser" class="flex width200">  
        <input type="text" class="margin-right size" v-model="username" placeholder="Username">
        <input type="text" class="margin-right size" v-model="email" placeholder="Email">
        <input type="text" class="margin-right size" v-model="firstName" placeholder="First name">
        <input type="text" class="margin-right size" v-model="lastName" placeholder="Last name">
        <p>
          <button type="submit" class="btn">Create user</button>
        </p>
      </form>
    </div>
    <p style="text-decoration: underline;cursor:pointer;" @click="pokazi" v-show="val1">More..</p>
    <div class="flex spaceBetween" v-show="val">
        <div class="flex">
        <input type="text" class="margin-right size" v-model="usernameOfUser" placeholder="Username of user" style="width: 30%">
        <button 
          class="btn"
          @click="getUserByUsername(usernameOfUser)"
        >
          Get  user by username
        </button>
      </div>
      <div class="flex">
        <input type="text" class="margin-right size" v-model="idOfUser" placeholder="Id of user">
        <button 
          class="btn"
          @click="getUserById(idOfUser)"
        >
          Get  user by id
        </button>
      </div>
      <div class="flex">
        <input type="text" class="margin-right size" v-model="editEmail" placeholder="Edit Email" style="width: 30%; margin-left:50%">
      </div>
      <div class="flex">
        <input type="text" class="size" v-model="newUsername" placeholder="Edit Username" style="width: 30%; margin-left:50%">
      </div>
      </div>
    <table>
      <tr>
        <th>UserName</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Id</th>
        <th>Actions</th>
      </tr>
      <tr
        v-for="(user, i) in users"
        :key="i"
      >
        <td>{{ user.username }}</td>
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.email }}</td> 
        <td>{{ user.id }}</td> 
        <td>
          <button class="btn margin-right" @click="editUser(user.id)">Edit Email</button>
          <button class="btn margin-right" @click="editUsername(user.id)">Edit Username</button>
          <button class="btn" @click="deleteUser(user.id)">Delete</button>
        </td>
      </tr>
    </table>
    <!-- <form @submit.prevent="uploadFile" class="column">
      <input type="file" id="myFile" name="filename">
      <input type="submit">
    </form> -->
    <div  v-if="response && response.data">
      <h5 style="text-decoration: underline;" v-show="value">
        Response from the backend application
      </h5>
      <h3 v-show="value">
        {{ response.data }}
      </h3>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HttpCommunication',

  data() {
    return {
      response: null,
      username: "",
      firstName: "",
      lastName: "",
      email: "",
      id: "",
      usernameOfUser: "",
      users: [],
      response_array: [],
      value: true,
      idOfUser: "",
      editEmail: "",
      val: false,
      val1: true,
      newUsername: ""
    };
  },
  methods: {
    async getListOfUsers() {
      //write the method you use on backend for getting all users
      this.response = await axios.post('http://localhost:8081/user/post');

      if(this.response.status===200){
        // eslint-disable-next-line
        //debugger;
        this.value=false;
        this.response_array=this.response.data;
        for(var i=0;i<this.response_array.length;i++){
          this.users.push(this.response_array[i]);
        }
      }

    },
    async getUserByUsername(username) {
      //write the method you use on backend for getting all users
      this.value=true;
      this.response = await axios.get('http://localhost:8081/user/username/'+username);
      this.usernameOfUser="";
    },
    async getUserById(id) {
      //write the method you use on backend for getting all users
      this.value=true;
      this.response = await axios.get('http://localhost:8081/user/'+id);
      this.idOfUser="";
    },
    async addUser() {
      //write the method you use on backend for adding
      this.response = await axios.post('http://localhost:8081/user', {
        username: this.username,
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email
      });
      if (this.response.status === 200) {
        this.value=true;
        this.users.push(this.response.data);
        this.username="";
        this.firstName="";
        this.lastName="";
        this.email="";
      }
    },
    async editUser(id) {
      //write the method you use on backend for editing user
      this.response = await axios.put('http://localhost:8081/user/'+id+'?email=' + this.editEmail);
      if(this.response.status===200){
        this.value=true;
        var index=this.users.findIndex(u => u.id == id);
        this.users[index] = this.response.data;
        this.editEmail="";
      }
    },
    async editUsername(id) {
      //write the method you use on backend for editing user
      this.response = await axios.post('http://localhost:8081/user/edit/'+id+'?username=' +this.newUsername,{});
      if(this.response.status===200){
        this.value=true;
        var index=this.users.findIndex(u => u.id == id);
        this.users[index] = this.response.data;
        this.newUsername="";
      }
    },
    async deleteUser(id) {
      //write the you use on backend for deleting
      this.response = await axios.delete('http://localhost:8081/user/delete/'+id);
      if(this.response.status===200){
        this.value=true;
        this.users.splice((this.users.findIndex(u => u.id == id)), 1);
      }
    },
    async pokazi(){
      this.val=true;
      this.val1=false;
    },
    //this is a simple example how we can override headers
    async getXMLResponse() {
      this.response = await axios.post('', {}, {
        headers: {
          'Content-Type': 'application/xml'
        }
      })
    },
    //this is a simple example how we can send value as RequestParam
    async getResponseWithRequestParam() {
      this.response = await axios.get(`http://localhost:8081/greeting?name=${ this.name }`)
    },
    //this is a simple example how we can send value as PathVariable
    async getResponseWithPathVariable() {
      this.response = await axios.get(`http://localhost:8081/greeting/${ this.name }/hello`)
    }
  }
}
</script>

<style scoped>
.column {
  display: flex;
  flex-direction: column;
}
.grayBorder {
  border: 1px solid gray;
}
.btn {
  height: 30px;
  margin-top: 6px;
  background-color: thistle;
  color: black;
  border: 1px solid gray;
}
.flex {
  display: flex;
  align-items: center;
}
.margin-right {
  margin-right: 5px;
}
table {
  margin-top: 20px;
  font-family: arial, sans-serif;
  border-collapse: collapse;
  border-spacing: 0 1em;
  width: 100%;
  /* background-color:thistle; */
  background-image: linear-gradient(thistle,rgb(235, 229, 229));
}
td, th {
  border: 3px solid white;
  text-align: left;
  padding: 10px;
}
/* tr:nth-child(even) {
  background-color: #dddddd;
} */
.spaceBetween {
  justify-content: space-between;
}
.size {
  height: 30px;
  width: 70px;
}
</style>
