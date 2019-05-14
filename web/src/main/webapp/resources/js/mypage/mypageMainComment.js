//이용약관 동의
    var doc = document; 
    var form1 = doc.getElementById('form1'); 
    var inputs = form1.getElementsByTagName('INPUT'); 
    var form1_data = {
      "cb": false, 
    }; 
    var c1 = doc.getElementById('cb'); 
    function checkboxListener() {
      form1_data[this.name] = this.checked; 
      if(this.checked) {
        // submit 할때 체크하지 않아 색이 변한 font 를 다시 원래 색으로 바꾸는 부분. 
        this.parentNode.style.color = "#000"; 
      }
    }
      c1.onclick = checkboxListener; 
      var all = doc.getElementById('all'); 
      all.onclick = function() {
        if (this.checked) {
          setCheckbox(form1_data, true); 
        } else {
          setCheckbox(form1_data, false); 
        }
      }; 
      function setCheckbox(obj, state) {
        for (var x in obj) {
          obj[x] = state; 
          for(var i = 0; i < inputs.length; i++) {
            if(inputs[i].type == "checkbox") {
              inputs[i].checked = state; 
            }
          }
        }
      } 