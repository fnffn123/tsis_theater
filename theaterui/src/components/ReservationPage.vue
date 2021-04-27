
<template>
  <div class="theaterui">
    <notifications group="notifyApp" position="top center" />
    <notifications group="notifyApp" position="top center" />
    <div class="display">
      <div @click="mkreservation">예매하기</div>
      <div>선택 된 좌석 : {{$route.params.seat}}</div>
      <form v-on:submit="onSubmitForm"> 
        <!-- v-model input에서 값을 받아올 이름 지정 --> 
        <div>예매자 이름</div>
        <input type="text" v-model="nm"> 
        <div>휴대폰 번호</div>
        <input type="text" v-model="phone">
      </form>

    </div>
    <div class="bottom">영화정보와 좌석정보를 확인하신 후 예매버튼을 눌러주세요.</div>
    <button @click="mkreservation" class="btm">예매</button> 
  </div>
</template>

<script>
export default {
  data(){
    return{
      current:null,
      row:10,
      col:10,
      nm:'',
      phone:'',
      apblist:['','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'],
      seatdata:[]
      
    }
  },
  methods: {
    onSubmitForm(e){
        // form의 새로 고침 막기 
        e.preventDefault(); 
        console.log("사용자이름 =" + this.nm); 
        console.log("폰번호 = " + this.phone); 
    },
    mkreservation() {
        if(this.nm!=''){
            if(this.phone!=''){
                for(var s=0; s<this.$route.params.seat.length;++s){
                    this.$axios
                    .post(
                    "http://localhost:8770/theater/make_reservation",null,
                    {
                        params: {
                            movie_RESERVATION_ID: 0,
                            owner_NM: this.nm,
                            phone_NUM: this.phone,
                            run_MOVIE_ID: this.$route.params.run_movie_id,
                            seat_NUM: this.$route.params.seat[s],
                        },
                    },
                    {
                        headers: {
                        "Content-Type": "application/x-www-form-urlencoded",
                        },
                    }
                    )
                    .then((res) => {
                    console.log(res);
                    })
                    .catch((error) => {
                    console.log(error);
                    throw new Error(error);
                    });
                    this.$notify({
                        group: 'notifyApp',
                        type: 'default',
                        duration:500,
                        title: '예매 완료',
                    })
                }
                

            }
            
            else{
                this.$notify({
                    group: 'notifyApp',
                    type: 'default',
                    duration:500,
                    title: '휴대폰 번호를 입력해주세요',
                })
            }
        }
        else{
            this.$notify({
                group: 'notifyApp',
                type: 'default',
                duration:500,
                title: '예매자 이름을 입력해주세요',
            })
        }
        
    },

  }
}
//array1.find(element => element > 10);
</script>

<style scoped>
.theaterui{
  margin: 0 auto;
  align-items: center;
  width: 1200px;
  font-size: 25px;
  border: 3px black;
}
.tb{
  margin: auto;
  width: 80%;
}

.display{
  grid-column: 1 / 5;
  color: plum;
}
.top{
  background-color: rgb(195, 241, 241);
}

.btn{
  background-color: mintcream;
  border: 1px solid black;
  margin: 10px;
}
.infos{
  grid-template-rows: repeat(300,50fr);
}
.oneseat{
  color: blueviolet;
}
.seats{
  background-color: aliceblue;
  width: 50px;
  height: 40px;
}
.bottom{
    margin-top: 100px;

}
</style>
