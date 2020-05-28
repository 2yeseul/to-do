var main = {
	    init : function () {
	        var _this = this;
	        $('#btn-save').on('click', function () {
	            _this.save();
	            $('#savePostsModal').modal("hide");
	            
	        });
	    },
	    save : function () {
	    	var title = $('#title').val();
	    	var isDone = "1";
	        var data = {
	            title: $('#title').val(),
	            isDone: "1"
	        };
	        console.log(data);
	        $.ajax({
	            type: 'POST',
	            url: '/posts',
	            dataType: 'json',
	            contentType:'application/json; charset=utf-8',
	            data: JSON.stringify(data),
	            success : function(data) {
	    			var html = "";
	    				html += '<tr id=row'+data+'>';
	    				html += '<td scope = "row"> ';
	    				html +='<div class="custom-control custom-checkbox">' 
	    				html +=	'<input type="checkbox" class="custom-control-input" id="'+data+'" onclick="isDone(this.id, '+isDone+')">';
	    				html += ' <label class="custom-control-label" for="'+data+'"></label> </td>';
	    				html += '<td id=myTitle'+data+'>' + $('#title').val() + '</td>'
	    				html += '<td> <a id='+data+' href="javascript:void(0);" onclick="deleteTodo(this.id)"><i class="fas fa-minus-circle"></i></a> </td>'
	    				$("#todo").append(html);
	    		}
	        }).done(function() {
	            //alert('할 일이 등록되었습니다.');
	           
	        }).fail(function (error) {
	            alert(error);
	        });
	    }

};

function isDone(clickedId, clickedIsDone) {
	var isDone;
	if(document.getElementById("myTitle"+clickedId).style.textDecoration == "line-through") {
		document.getElementById("myTitle"+clickedId).style.textDecoration = "none";
		isDone = "1";
	}
		
	else {
		document.getElementById("myTitle"+clickedId).style.textDecoration = "line-through";
		isDone ="0";
	}
	var temp = clickedId;
	/*if(clickedIsDone == "0") isDone = "1";
	else isDone = "0";*/
	var data = {
		"isDone" : isDone,
		"id" : temp
	};
	console.log(data);
			$.ajax({
				type: "POST",
				url: "/edit",
				async : true,
				contentType : "application/json; charset=UTF-8",
				data: JSON.stringify(data),
				success: function(data) {
					console.log(clickedId);
					var tag = "#row"+temp;
					
			}

		});
}

function deleteTodo(clickedId) {
	console.log(clickedId);
	var id = clickedId;
	var rowId = "#row"+id;
	
	var data = {
			"id" : clickedId
	};
	console.log(data);
	$.ajax({
		type: "POST",
		url: "/delete",
		contentType : "application/json; charset=UTF-8",
		data: JSON.stringify(data),
		success: function() {
			$(rowId).remove();
		},
		error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
         }
	})
	
}

	main.init();