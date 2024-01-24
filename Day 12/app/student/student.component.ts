import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  public studentDetails: any[];
  public newStudent = { name: '', age: null, grade: '' };
  public selectedStudent: any = null;

  constructor() {
    this.studentDetails = [
      { name: 'Kavya Nayana', age: 21, grade: 'A' }
    ];
  }

  addStudent() {
    this.studentDetails.push(this.newStudent);
    this.newStudent = { name: '', age: null, grade: '' };
  }
  ngOnInit(): void {
  }

}
