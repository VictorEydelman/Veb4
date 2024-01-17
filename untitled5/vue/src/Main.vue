<template>
    <div id="container" name="contain">
      <header>
        Эйдельман Виктор Аркадьевич, группа P3214, вариант № 2470
      </header>
      <div class="container" id="contain">
        <div>
          <p>Введите X</p>
          <div>
          <input type="radio" id="x1" class="x" value="-5" v-model="x">
          <label for="x1">-5</label>
          <input type="radio" id="x2" class="x" value="-4" v-model="x">
          <label for="x2">-4</label>
          <input type="radio" id="x3" class="x" value="-3" v-model="x">
          <label for="x3">-3</label>
          <br>
          <input type="radio" id="x4" class="x" value="-2" v-model="x">
          <label for="x4">-2</label>
          <input type="radio" id="x5" class="x" value="-1" v-model="x">
          <label for="x5">-1</label>
          <input type="radio" id="x6" class="x" value="0" v-model="x">
          <label for="x6">0</label>
          <br>
          <input type="radio" id="x7" class="x" value="1" v-model="x">
          <label for="x7">1</label>
          <input type="radio" id="x8" class="x" value="2" v-model="x">
          <label for="x8">2</label>
          <input type="radio" id="x9" class="x" value="3" v-model="x">
          <label for="x9">3</label>
            <h7 v-if="x===''" style="color: red">X не выбран</h7>
          </div>
          <div>
          <p>Введите Y</p>
          <div>
          <input v-model="y" placeholder="Введите Y">
            <h7 v-if="validaty()" style="color: red">Ошибка в вводе Y</h7>
          </div>
          </div>
          <div>
          <p>Введите R</p>
          <div>
          <input type="radio" id="r1" class="r" value="-5" v-model="r">
          <label for="r1">-5</label>
          <input type="radio" id="r2" class="r" value="-4" v-model="r">
          <label for="r2">-4</label>
          <input type="radio" id="r3" class="r" value="-3" v-model="r">
          <label for="r3">-3</label>
          <br>
          <input type="radio" id="r4" class="r" value="-2" v-model="r">
          <label for="r4">-2</label>
          <input type="radio" id="r5" class="r" value="-1" v-model="r">
          <label for="r5">-1</label>
          <input type="radio" id="r6" class="r" value="0" v-model="r">
          <label for="r6">0</label>
          <br>
          <input type="radio" id="r7" class="r" value="1" v-model="r">
          <label for="r7">1</label>
          <input type="radio" id="r8" class="r" value="2" v-model="r">
          <label for="r8">2</label>
          <input type="radio" id="r9" class="r" value="3" v-model="r">
          <label for="r9">3</label>
            <h7 v-if="validatr()" style="color: red">R не выбран</h7>
          </div>
          </div>
          <br>
          <button id="submit-button" :disabled="this.x==='' || validaty() || this.r===''" @click="validateForm" type="submit">Отправить на проверку</button>
          <button @click="deletedata" type="submit">Очистить</button>
          <button @click="logout" type="submit">Выйти из акаунта</button>
        </div>
      </div>
      <div id="imgt">
        <div class="img" id="img">
          <svg id="svg" height="400" width="400" @click="svg()">
            <line stroke="black" x1="20" x2="260" y1="140" y2="140"></line>
            <line stroke="black" x1="140" x2="140" y1="20" y2="260"></line>
            <polygon id="stry" fill="black" points="140,20 134,35 146,35" stroke="black"></polygon>
            <polygon id="strx" fill="black" points="260,140 245,146 245,134" stroke="black"></polygon>

            <line stroke="black" x1="180" x2="180" y1="145" y2="135"></line>
            <line stroke="black" x1="220" x2="220" y1="145" y2="135"></line>
            <line stroke="black" x1="60" x2="60" y1="145" y2="135"></line>
            <line stroke="black" x1="100" x2="100" y1="145" y2="135"></line>
            <line stroke="black" x1="135" x2="145" y1="100" y2="100"></line>
            <line stroke="black" x1="135" x2="145" y1="60" y2="60"></line>
            <line stroke="black" x1="135" x2="145" y1="220" y2="220"></line>
            <line stroke="black" x1="135" x2="145" y1="180" y2="180"></line>

            <polygon v-if="r>=0" fill="blue"
                     fill-opacity="0.7"
                     stroke="blue"
                     points="140,140 60,140 60,100 140,100"></polygon>
            <polygon v-if="r>=0" fill="blue"
                     fill-opacity="0.7"
                     stroke="blue"
                     points="140,140 140,180 220,140"></polygon>
            <path v-if="r>=0" fill="blue"
                  fill-opacity="0.7"
                  stroke="blue"
                  d="M 140 140 L 140 220 A 80,80 0 0,1 60,140 Z"></path>
            <polygon v-if="r!=='' && r<0" fill="blue"
                     fill-opacity="0.7"
                     stroke="blue"
                     points="140,140 220,140 220,180 140,180"></polygon>
            <polygon v-if="r!=='' && r<0" fill="blue"
                     fill-opacity="0.7"
                     stroke="blue"
                     points="140,140 140,100 60,140"></polygon>
            <path v-if="r!=='' && r<0" fill="blue"
                  fill-opacity="0.7"
                  stroke="blue"
                  d="M 140 140 L 140 60 A 80,80 0 0,1 220,140 Z"></path>

            <text fill="black" x="170" y="130" id="r/2">R/2</text>
            <text fill="black" x="215" y="130" id="r">R</text>
            <text fill="black" x="50" y="130" id="-r">-R</text>
            <text fill="black" x="85" y="130" id="-r/2">-R/2</text>
            <text fill="black" x="110" y="180" id="2-r/2">-R/2</text>
            <text fill="black" x="120" y="220" id="2-r">-R</text>
            <text fill="black" x="120" y="60" id="2r">R</text>
            <text fill="black" x="110" y="100" id="2r/2">R/2</text>
            <text fill="black" x="245" y="130" id="xr">X</text>
            <text fill="black" x="150" y="35" id="yr">Y</text>
            <text x="20" y="300" v-if="validatr() && provsvg===1"  fill="red">R не выбран</text>
          </svg>
        </div>
      </div>
      <div id="frame" class="contain">
        <table>
          <thead>
          <th>x</th>
          <th>y</th>
          <th>r</th>
          <th>result</th>
          <th>time</th>
          </thead>
          <tbody>
          <tr v-for="dot in dots" :key="dot">
            <td>{{dot.x}}</td>
            <td>{{dot.y}}</td>
            <td>{{dot.r}}</td>
            <td>{{dot.result}}</td>
            <td>{{dot.time}}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
</template>
<script>
export default {
  name: 'contain',
  data () {
    return {
      employees: [],
      x: '',
      y: '',
      r: '',
      provx:0,
      provy:0,
      provr:0,
      provsvg:0,
      dots: new Array(0)
    }
  },
  methods: {

    validateForm() {
      if (this.validat() && localStorage.getItem("jwt")!=="") {
        this.$axios.put("http://localhost:9876/api/data", {x: this.x, y: this.y, r: this.r}
          , {headers: {"Authorization":"Bearer "+localStorage.getItem("jwt")}}
        ).then((response) => {
          this.$axios.get("http://localhost:9876/api/data"
            , {headers: {"Authorization":"Bearer "+localStorage.getItem("jwt")}}
          ).then((response) => {
            this.dots = response.data
            this.drawDots()
          }).catch((response) => {
          });
        }).catch((response) => {
        });
      } else if(this.validat()){
        alert("Не авторизирован")
      } else {
        alert("Не верные данные")
      }
    },
    deletedata(){
      this.$axios.delete("http://localhost:9876/api/data"
        , {headers: {"Authorization":"Bearer "+localStorage.getItem("jwt")}}
      ).then((response) => {
      }).catch((response) => {
      });
    },
    validat() {
      return this.x !== '' && this.y !== '' && this.r !== '';
    },
    validaty(){
        if (!this.y.includes(".")) {
          this.y = this.y.replace(',', '.');
        }
        if (this.y === "") {
          return true
        } else if (isNaN(this.y) && this.y !== "-" && !this.y.includes(",")) {
          return true
        } else if (this.y < -5 || this.y > 3) {
          return true
        }
        return false
    },
    validatr(){
      if(this.r===''){
        return true
      }
      var rad=this.r
      if(rad<0){
        rad=-rad
      }
      document.getElementById("-r").innerHTML = -rad;
      document.getElementById("2-r").innerHTML = -rad;
      document.getElementById("r").innerHTML = rad;
      document.getElementById("2r").innerHTML = rad;
      document.getElementById("-r/2").innerHTML = -rad/2;
      document.getElementById("2-r/2").innerHTML = -rad/2;
      document.getElementById("r/2").innerHTML = rad/2;
      document.getElementById("2r/2").innerHTML = rad/2;
      return false
    },
    svg(){
      function getMousePosition(element, event) {
        let rect = element.getBoundingClientRect();
        return {
          x: event.clientX - rect.left,
          y: event.clientY - rect.top
        };
      }
      let svg= getMousePosition(document.getElementById("svg"), event);

      if(this.r!==""){
        this.x=(svg.x-140)/80*this.r
        this.y=(140-svg.y)/80*this.r
        this.x=this.x.toFixed(16)
        this.y=this.y.toFixed(16)
        this.validateForm()
        this.x=''
        this.y=''
      } else {
        this.provsvg=1
      }
    },
    logout(){
      this.$router.push({name:'first'})
    },
    drawDots(){
      let r = parseFloat(this.r);
      let svg = document.getElementById("svg")
      let oldDots = document.querySelectorAll("circle");
      oldDots.forEach(oldDot => oldDot.parentNode.removeChild(oldDot));

      if(this.dots.length !== 0){
        this.dots.forEach(dot => {
          let newDot = document.createElementNS("http://www.w3.org/2000/svg", "circle");
          newDot.setAttribute("id", "target-dot");
          newDot.setAttribute("r", "3.5");
          if(dot.r===0){
            newDot.setAttribute("cx", `${140}`);
            newDot.setAttribute("cy", `${140}`);
          }else {
            newDot.setAttribute("cx", `${dot.x * 80 / dot.r + 140}`);
            newDot.setAttribute("cy", `${140 - dot.y / dot.r * 80}`);
          }
          newDot.setAttribute("fill", dot.result === "Входит" ? "green" : "red");
          newDot.setAttribute("r", "4.5");
          svg.appendChild(newDot);
          if(dot.r===0){
            dot.x=0
            dot.r=0
          }
        })
      }
    }

  }
}

</script>
<style>
.img {
  margin-left: 30%;
  margin-top: 3%;
  text-align: center;
  display: block;
  width: 240px;
  height: 240px;
}

#imgt{
  top: 50px;
  width:50%;
  height: 380px;
  background: #069d06;
  max-width: 47%;
  margin-top: 1.4%;
  margin-right: 2%;
  position: absolute;
  right: 0px;
  float:right;
  border-radius: 50px;
  box-shadow: 0 0 0 4px #968089, 2px 1px 6px 4px rgba(150, 128, 137, 0.5);
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
.container{
  height: 380px;
  margin-top: 3%;
  margin-left: 2%;
  text-align: center;
  color: black;
  border-radius: 50px;
  box-shadow: 0 0 0 4px #968089, 2px 1px 6px 4px rgba(150, 128, 137, 0.5);
  vertical-align:middle;
  background:rgba(8,24,203,0.96);
  max-width:47%;
}
.contain{
  margin-top: 1%;
  text-align: center;
  vertical-align:middle;
  background: rgba(196, 119, 23, 0.96);
}
.container R{
  margin-left: auto;
  margin-right: auto;
}
.container p{
  text-align: center;
  display: inline-block;
}
#frame{
  border-radius: 50px;
  box-shadow: 0 0 0 4px #968089, 2px 1px 6px 4px rgba(150, 128, 137, 0.5);
}
button:hover{
  color: red
}
#toStart:hover{
  color: red
}
::selection{
  color: white;
  background-color: black;
}
.container .prov1 .prov{
  color: red;
}
input option{
  text-align: center;
}
frame{
  border-bottom:100px;
}
table{
  margin-left: auto;
  margin-right: auto;
  width: 100%;
}

.messageCheckbox{
  height: 20px;
  width: 35px;
}
td,th{
  text-align: center;
  width: 20%;
}
</style>
