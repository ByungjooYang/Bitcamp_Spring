function checkBoardWrite(){
	if(document.boardWriteForm.subject.value == ""){
		alert("제목을 입력해주세여");
		document.getElementById("subject").title.focus();
		
	} else if (document.getElementById("content").value == "") {
		alert("내용을 입력해주세요");
		document.getElementById("content").focus();
		
	} else{
		document.boardWriteForm.submit();
		
	}
		
}

function checkLogin(){
	alert("로그인을 해야 볼 수 있습니다!");
	// if(memId == 'null')=> null이 아니라 null이라는 글자로 넘어온다. =>세션값을 파라미터로 얻어올때
	//if(<%session.getAttribute("memId" == null)%>) alert("로그인해!") =>단, js파일에서는 못하고 jsp 파일 내에서 script 걸어서 쓰면 된다.
	//else location.href="boardView.jsp?seq=" + seq + "&pg=" + pg // 파라미터로 memid, seq, pg값을 받는다.
}

function checkModify(){
	if(document.boardModifyForm.subject.value == ""){
		alert("제목을 입력해주세여");
		document.getElementById("subject").title.focus();
		
	} else if (document.getElementById("content").value == "") {
		alert("내용을 입력해주세요");
		document.getElementById("content").focus();
		
	} else{
		document.boardModifyForm.submit();
		
	}
}

function boardPaging(pg){
	location.href="boardList.do?pg="+pg;
}

function searchPaging(pg){
	location.href="boardSearch.do?pg="+pg + "&searchOption=${searchOption}&keyword=" + encodeURIComponent("${keyword}");
	//encodeURI(); => 특수문자는 인코딩 안해줌.
}

function imagePaging(pg){
	location.href="imageboardList.do?pg="+pg;
}

function checkBoardReplyForm(){    
	if(document.boardReplyForm.subject.value == ""){
        alert("제목을 입력하세요.");
        document.boardReplyForm.subject.focus();
    } else if(document.boardReplyForm.content.value == "") {
    	alert("내용을 입력하세요.");
    	document.boardReplyForm.content.focus();
    } else  {
    	document.boardReplyForm.submit();
    } 
}

function allClick(){
	let allNum = document.getElementById("allNum");			//id는 하나밖에 없음.
	let seq = document.getElementsByName("seq");  //name들을 배열 형식으로 받아온다.
	
	for(i=0;i<seq.length;i++){
		seq[i].checked = allNum.checked;
	}
	
	/*
	 * if(allNum.checked){
	 *  seq[i].checked=true;
	 * }
	 */
}

function indivClick(){
	let seq = document.getElementsByName("seq");
	let allNum = document.getElementById("allNum");
	
	for(i=0;i<seq.length;i++){
		if(!seq[i].checked){
			allNum.checked = false;		
		
		}
	
	}
	if(seq[0].checked && seq[1].checked && seq[2].checked){
		allNum.checked = true;
	}
}

function choiceDelete(){
	let seq = document.getElementsByName("seq");
	let seqArr = [];
	
	for(i=0;i<seq.length;i++){
		/*if(!seq[i].checked){
			seq[i].value = 0;
		}*/
		if(seq[i].checked){
			seqArr.push(seq[i].value);
		}
	}
	
	/*if(!seq[0].checked && !seq[1].checked && !seq[2].checked){
		alert("먼저 선택하세요.");
		
	}else {
		let del = confirm("삭제하시겠습니까?");
		
		if(del){
			//location="/miniProject/board/imageboardDelete.do?seq=" + seq[0].value + "&seq1=" + seq[1].value + "&seq2=" + seq[2].value;
			location="/miniProject/board/imageboardDelete.do?seq=" + seqArr; 
		
		} else {
			alert("취소되었습니다.");
		}
	}*/
	
	if(seqArr.length == 0){
		alert("먼저 선택하세요");
	
	}else {
		let del = confirm("삭제하시겠습니까?");
		
		if(del){
			//location="/miniProject/board/imageboardDelete.do?seq=" + seq[0].value + "&seq1=" + seq[1].value + "&seq2=" + seq[2].value;
			location="/miniProject/board/imageboardDelete.do?seq=" + seqArr; 
		
		} else {
			alert("취소되었습니다.");
		}
	}
	
	
}
