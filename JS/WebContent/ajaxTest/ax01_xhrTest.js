// 1. XMLHttpRequest객체를 생성
// 2. 클라이언트로부터 요청 이벤트 발생시 실행되는 메소드
//		=> startMethod()
//		=> 생성된 객체의 메서드 를 이용해서 
//	`	=> 요청준비(결과 처리를 담당할 메서드를지정), 설정, 보냄
// 3. 결과 처리를 담당할 메서드를 작성
//		=> 응답결과가 오면 자동으로 실행

var xhrObj ; //XMLHttpRequest객체를 저장할 변수를 전역변수로 선언
// 1.
function createXHR() { 
// XMLHttpRequest객체를 생성하는 메소드	
	if (window.ActiveXObject) {
		//웹 브라우저가 IE5.0, IE6.0인 경우
		xhrObj = new ActiveXObject("Microsoft.XMLHTTP") ;
	} else if (window.XMLHttpRequest) {
		//웹 브라우저가 IE7.0 이상, 파이어폭스, 사파리, 오페라등의 경우
		xhrObj = new XMLHttpRequest();
	}
} // createXHR()

// 2. 이벤트 발생시 실행되는 메소드
// Test1.
function startMethod() {
	// 2.1)
	createXHR();
	// 2.2) 응답결과를 담당할 메서드를 설정
	// =>응답처리를 위한 이 메서드는 () 없이 기술해야 한다.
	xhrObj.onreadystatechange = resultF ; 
	// 2.3) 요청설정
	// => index.html 페이지를 요청
	xhrObj.open("Get", "js15_Test_imageSize.html", true) ;
	// Get 방식, 요청페이지(url), 비동기적 통신이면 "true"
	// 2.4) 요청전송
	// => Get 방식이면 null, Post 방식이면 전송 Data
	xhrObj.send(null);
} // startMethod()

//Test2.
function getParameterValues() {
	var id=document.getElementById('id').value;
	var password=document.getElementById('password').value;
	var name=document.getElementById('name').value;
	return 'id='+id+'&password='+password+'&name='+name;
} // getParameterValues

function startMethodG() {
	createXHR();
	xhrObj.onreadystatechange = resultF ; 
	xhrObj.open("Get", "ax01_paramResult.jsp?"+getParameterValues(), true) ;
	xhrObj.send(null);
} // startMethodG()

function startMethodP() {
	createXHR();
	xhrObj.onreadystatechange = resultF ; 
	xhrObj.open("Post", "ax01_paramResult.jsp", true) ;
	xhrObj.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=utf-8");
	xhrObj.send(getParameterValues());
} // startMethodG()

// 3. 결과 처리를 담당할 메서드를 작성
//  => 응답결과가 오면 자동으로 실행
function resultF() {
	if (xhrObj.readyState==4) {
		//요청객체의 상태가 모든 데이터를 받을 수 있는 상태로 완료된 경우
		if (xhrObj.status==200) {
			//document.write("서버로부터의 응답 내용 : <br>"+xhrObj.responseText);
			document.getElementById("resultArea").innerHTML
			     ="서버로부터의 응답 내용 : <br>"+xhrObj.responseText ;
			// xhrObj.responseText : 문자열로 이루어진 서버의 응답을 받아서 화면에 표시
		}
	}	
} // resultF() 

