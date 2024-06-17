<template>
  <div>
    <header>
      Эйдельман Виктор Аркадьевич, группа P3214, вариант № 2470
    </header>
    <div>
      <div id="regist" align="center">
        <p>Введите логин</p>
        <input v-model="login" placeholder="Введите Логин">
        <br>
        <p>Введите пароль</p>
        <input type="password" v-model="password" placeholder="Введите Пароль">
        <br>
        <br>
        <button id="submit-button" @click="logIn" type="submit">Войти</button>
        <button id="submit-button" @click="regist" type="submit">Зарегистрироваться</button>
      </div>
    </div>
  </div>
</template>
<script>
document.addEventListener("DOMContentLoaded",function (){
  localStorage.setItem("jwt","")
})
export default {
  name: 'contain',
  data () {
    return {
      login:'',
      password:''
    }
  },
  methods:{
    logIn(e){
      e.preventDefault();
      this.$axios.post("http://localhost:9876/api/users",
        {login:this.login,password:this.password},
      ).then((response) => {
        localStorage.setItem("jwt",response.data)
        this.$router.push({name:'main'})
      }).catch(error => {
        alert(error.response.data)
      });
    },
    regist(){
      localStorage.setItem("jwt","")
      this.$axios.put("http://localhost:9876/api/users",
        {login:this.login,password:this.password}).then((response) => {
        localStorage.setItem("jwt",response.data)
        this.$router.push({name:'main'})
      }).catch(error => {
        alert(error.response.data)
      });
    }
  }
}

</script>

<style>
#regist{
}
header {
  font-family: fantasy;
  color:#faf3f0;
  font-size: 24px;
  font-style: normal;
  font-variant: normal;
  font-weight: 700;
  line-height: 26.4px;
  background-color: #7812a1;
  text-align:center;
  border-bottom-left-radius: 50px;
  border-bottom-right-radius: 50px;
  box-shadow: 0px 5px 0px 0px #968089
}
</style>
