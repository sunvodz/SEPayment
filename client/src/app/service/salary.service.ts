import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class SalaryService {

  constructor(private http: HttpClient) {
}
getStaff(): Observable<any> {
    return this.http.get('//localhost:8080/staff');
}
getPayer(): Observable<any> {
    return this.http.get('//localhost:8080/payer');
}
getPosition(): Observable<any> {
    return this.http.get('//localhost:8080/position');
  }
  getGender(): Observable<any> {
    return this.http.get('//localhost:8080/gender');
  }
  getJobtype(): Observable<any> {
    return this.http.get('//localhost:8080/jobtype');
  }
  getEducation(): Observable<any> {
    return this.http.get('//localhost:8080/education');
  }
}
