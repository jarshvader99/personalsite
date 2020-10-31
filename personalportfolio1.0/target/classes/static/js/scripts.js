$(document).ready(function(){
	
	$(".close").click("on", function(){
		window.location = "/";
	});
	
	function myFunction() {
	    var input, filter, ul, li, a, i, txtValue;
	    input = document.getElementById("search-bar");
	    filter = input.value.toUpperCase();
	    ul = document.getElementById("myUL");
	    li = ul.getElementsByTagName("li");
	    for (i = 0; i < li.length; i++) {
	    	a = li[i].getElementsByTagName("span")[0];
	        txtValue = a.textContent || a.innerText;
	        if (txtValue.toUpperCase().indexOf(filter) > -1) {
	            li[i].style.display = "";
	        } else {
	            li[i].style.display = "none";
	        }
	    }
	}

	function likeMovie(resultId)
	{
		console.log('hiee');
		console.log(resultId);
		$.ajax({
		    url: "/likeMovie?movieId=" + resultId,
		    type: "GET",
		    dataType : "json",
		    success: function(response){
		    	console.log(response);
		           if(response)
		       	   {
		       	   	console.log('updated');
		       	   }
		           else
		       	   {
		       	   	console.log('failed');
		       	   }
		    },
			error: function(){
				$('#like-movie-thumb-' + resultId).addClass("likeMovie");
			}
		});
	}

	function dislikeMovie(resultId)
	{
		console.log('dis');
		console.log(resultId);
		$.ajax({
		    url: "/dislikeMovie?movieId=" + resultId,
		    type: "GET",
		    dataType : "json",
		    success: function(response){
		    	console.log(response);
		           if(response)
		       	   {
		       	   	console.log('updated');
		       	   }
		           else
		       	   {
		       	   	console.log('failed');
		       	   }
		    },
			error: function(){
				$('#like-movie-thumb-' + resultId).removeClass("likeMovie");
			}
		});
	}




	
});