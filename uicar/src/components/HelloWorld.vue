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
          <td>
          <button @click="showSpec(car)">Abrir Specs</button>
        </td>
        </tr>
      </tbody>
    </table>

    <div v-if="selectedCar" class="popup">
      <div class="popup-content">
        <h2>Especificaciones del automóvil</h2>
        <p>ID: {{ selectedCar.type }}</p>
        <p>Marca: {{ selectedCar.brand }}</p>
        <p>Año: {{ selectedCar.year }}</p>
        <p>Color: {{selectedCar.color}}</p>
        <p>Price: {{selectedCar.price}}</p>
        <p>Turbo: {{selectedCar.turbo}}</p>
        <p>Motor: {{selectedCar.motor}}</p>
        <p>Popularity: {{selectedCar.popularity}}</p>
        <p>Cabinas: {{selectedCar.cabinas}}</p>
        <p>Sunroof: {{selectedCar.sunroof}}</p>
        <button @click="closePopup">Cerrar</button>
      </div>
    </div>

  </div>
</template>

<script>

import axios from 'axios';
  
export default {
  data(){
    return{
      quantity: 0,
      cars: null,
      selectedCar:null
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
    },
    showSpec(car) {
      this.selectedCar = car;
    },
    closeSpec() {
      this.selectedCar = null;
    }
  }
}
</script>

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
