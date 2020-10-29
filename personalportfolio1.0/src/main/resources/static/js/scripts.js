$(document).ready(function(){
	
	$(".close").click("on", function(){
		window.location = "/";
	});
	

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