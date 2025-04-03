class Solution {
    public String solution(String new_id) {
		new_id = new_id.toLowerCase();  // 1. 소문자 변환
		new_id = new_id.replaceAll("[^[a-z0-9-_.]]", "");   // 2. 문자 배열 제외 제거
		new_id = new_id.replaceAll("[.]{2,}", "."); // 3. 마침표 2개 하나로 치환
		new_id = new_id.replaceAll("^[.]+|[.]+$", "");  // 4. 마침표 처음 끝 제거
		new_id = new_id.replaceAll("^$", "a");   // 5. 빈 문자열 a 대입
		new_id = new_id.replaceAll("^(.{15}).*", "$1"); // 6.
		new_id = new_id.replaceAll("[.]$", "");
        
        if (new_id.length() < 1) {
            return "aaa";  // 기본값으로 "aaa" 반환
        }
		while(new_id.length() < 3) {    // 7. 문자열 2자 이하일때 3될때까지 반복
			new_id += new_id.charAt(new_id.length() - 1);
		}
        return new_id;
    }
}
