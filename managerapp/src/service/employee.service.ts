import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Employee} from "../model/employee";
import {environment} from "../environments/environment";

@Injectable({providedIn:"root"})

export class EmployeeService {
  private apiServerUrl = environment.apiUrl;

  constructor(private http: HttpClient) {console.log('Employee Service Initialized...');}

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiServerUrl}/manager/employee/all`);
  }

  public addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/manager/employee/add`, employee);
  }

  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiServerUrl}/manager/employee/update`, employee);
  }

  public deleteEmployee(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/manager/employee/delete/${id}`);
  }
}
