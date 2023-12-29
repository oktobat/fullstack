<template lang="">
    <section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>HOPE BOOK FORM</h3>
				
			</div>
		
			<div class="register_hope_book_form">
			
				<form name="update_hope_book_form" method="post">
                    <input type="text" name="hb_name" v-model="item.hb_name"> <br>
					<input type="text" name="hb_author" v-model="item.hb_author"> <br>
					<input type="text" name="hb_publisher" v-model="item.hb_publisher"> <br>
					<input type="text" name="hb_publish_year" v-model="item.hb_publish_year"> <br>
					<input type="button" value="등록" @click="updateHopeBookForm();"> 
					<input type="reset" value="취소">
					<router-link to="/getHopeBooks"><input type="button" value="목록"></router-link>
				</form>
				
			</div>
		
		</div>
		
	</section>
</template>
<script>
import axios from 'axios';
export default {
    name:"HopeBookUpdateForm",
    data(){
        return {
            item : { }
        }
    },
    created() {
        const itemString = this.$route.query.item;
        if (itemString) {
            this.item = JSON.parse(itemString);
            console.log(this.item);
        }
    },
    methods : {
        updateHopeBookForm(){

            const formData = {
                hb_no : this.item.hb_no,
                u_m_no: this.item.u_m_no,
                hb_name: this.item.hb_name,
                hb_author: this.item.hb_author,
                hb_publisher: this.item.hb_publisher,
                hb_publish_year: this.item.hb_publish_year,
                hb_result: this.item.hb_result
            };

            console.log(formData);

            if (this.hb_name == '') {
                alert('INPUT BOOK NAME.');
            } else if (this.hb_author == '') {
                alert('INPUT BOOK AUTHOR.');
            } else if (this.hb_publisher == '') {
                alert('INPUT BOOK PUBLISHER.');
            } else if (this.hb_publish_year == '') {
                alert('INPUT BOOK PUBLISH YEAR.');
            } else {
                axios.post('http://localhost:8090/api/updateHopeBookConfirm', formData, {
                headers : { 'Content-Type': 'application/json' }
                })
                .then((response)=>{
                    this.hb_name="";
                    this.hb_author="";
                    this.hb_publisher="";
                    this.hb_publish_year="";
                    this.$router.push("/getHopeBooks")
                })
                .catch((error)=>{
                    console.log('Error fetching data:', error);
                })
            }

            

        }
    }
}
</script>
<style scoped>
    section {
	margin: 30px 0;
	}

#section_wrap {
	max-width: 1200px;
	margin: 0 auto;
	}

#section_wrap .word {
	text-align: center;
	}
	
#section_wrap .register_hope_book_form {
	text-align: center;
	}

#section_wrap .register_hope_book_form input {
	width: 300px;
    padding:10px;
	margin: 3px;
	}

#section_wrap .register_hope_book_form select {
	width: 322px;
	margin: 3px;
	}

#section_wrap .register_hope_book_form input[type='button'],
#section_wrap .register_hope_book_form input[type='reset'] {
	width: 156px;
	}
</style>