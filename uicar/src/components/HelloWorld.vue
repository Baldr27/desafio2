<template>
  <div class="container">
    <div>
      <form @submit.prevent="submitForm">
        <input type="number" v-model="quantity" placeholder="Enter quantity">
        <button type="submit">Generate</button>
      </form>
    </div>
    <table class="table table-striped" v-if="cars">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Brand</th>
          <th scope="col">Year</th>
          <th scope="col">Color</th>
          <th scope="col">Price</th>
          <th scope="col">Turbo</th>
          <th scope="col">Type</th>
          <th scope="col">Motor</th>
          <th scope="col">Popularity</th>
          <th scope="col">Cabinas</th>
          <th scope="col">Sunroof</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="car in cars" :key="car.id">
          <td>{{car.id}}</td>
          <td>{{car.brand}}</td>
          <td>{{car.year}}</td>
          <td>{{car.color}}</td>
          <td>{{car.price}}</td>
          <td>{{car.turbo}}</td>
          <td>{{car.type}}</td>
          <td>{{car.motor}}</td>
          <td>{{car.popularity}}</td>
          <td>{{car.cabinas}}</td>
          <td>{{car.sunroof}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
//import { reactive } from 'vue';
import axios from 'axios';
  
export default {
  data(){
    return{
      quantity: 0,
      cars: null,
    };
  },
  methods:{
    generate(){
      axios.get(`http://localhost:3001/api/generate?quantity=${this.quantity}`)
        .then(response => {
          this.cars = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    submitForm(){
      this.generate();
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
