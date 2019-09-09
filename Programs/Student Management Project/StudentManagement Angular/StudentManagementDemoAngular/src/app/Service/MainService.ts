import { Injectable } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { LoginVO } from '../Shared/LoginVO'
import { Router } from '@angular/router';
import { RegistrationVO } from '../Shared/RegistrationVO';

@Injectable()
export class MainService {

    loginForm: FormGroup;
    registrationForm: FormGroup;
    radioOptionForLogin: Number;
    loginVO = new LoginVO();
    data: any
    radioOptionForGender: String;
    stateList: any;
    departmentList: any
    selectedStateId: any
    cityList: any;
    selectedCityId: any
    selectedDeptId: any
    registrationVO = new RegistrationVO();

    constructor(private fb: FormBuilder, private httpClient: HttpClient, private router: Router) { }

    validateLogin() {
        this.loginForm = this.fb.group({

            id: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(5)]]
        });
    }

    onSubmit(form: FormGroup) {

        this.loginVO.userId = form.value.id;
        this.loginVO.userPassword = form.value.password;
        this.loginVO.userTypeCode = this.radioOptionForLogin;
        console.log("LoginVO is.......", this.loginVO);

        if (this.loginVO.userTypeCode == 1) {
            //Admin Login
            console.log("Inside Admin login");
            const promise = this.httpClient.post('http://localhost:8180/StudentManagement-0.0.1-SNAPSHOT/api/main/validateCredentials/', this.loginVO);
            promise.subscribe(
                data => {
                    this.data = data
                    console.log("data is----------", data);
                    this.router.navigate(['./adminHome']);
                },
                error => {
                    console.log("error occured while authentication------", error);
                    window.alert("Userid or Password is incorrect");
                    this.router.navigate(['./login']);
                    this.loginForm.reset();

                }
            )
        }
        else {
            //Student Login
            console.log("Inside Student login");
            const promise = this.httpClient.post('http://localhost:8180/StudentManagement-0.0.1-SNAPSHOT/api/main/validateCredentials/', this.loginVO);
            promise.subscribe(
                data => {
                    this.data = data;
                    console.log("data is----------", data);
                    this.router.navigate(['./studentHome']);
                },
                error => {
                    console.log("error occured while authentication------", error);
                    window.alert("Userid or Password is incorrect");
                    this.router.navigate(['./login']);
                    this.loginForm.reset();
                })
        }
    }

    registerStudent() {
        console.log("Inside registerStudent");
        //first fetch state & department for dropdowns
        this.fetchStates();
        this.fetchDepartments();
        console.log("Everything is OK");
        this.router.navigate(['./registerStudent']);
    }

    fetchStates(){
        const promise = this.httpClient.get('http://localhost:8180/StudentManagement-0.0.1-SNAPSHOT/api/main/getAllStates');
        promise.subscribe(
            data => {
                this.stateList = data;
            console.log("States are------", this.stateList);
             
            }
        )
    }

    fetchDepartments(){

        const promise = this.httpClient.get('http://localhost:8180/StudentManagement-0.0.1-SNAPSHOT/api/main/getDepartments');
            promise.subscribe(
                data => {
                    this.departmentList = data;
                console.log("Departments are------", this.departmentList);
                 
                }
            )

    }

    

    getCities(selectedStateId) {

        console.log("Selected state is-------", selectedStateId);
        const promise = this.httpClient.get('http://localhost:8180/StudentManagement-0.0.1-SNAPSHOT/api/main/getCities/' + selectedStateId);
        promise.subscribe(
            data => {
                this.cityList = data;
                console.log("Cities  are------", this.cityList);
            }
        )

    }


    validateRegistration() {
        console.log("Inside validateRegistration");
        this.registrationForm = this.fb.group({
            firstName: ['', Validators.required],
            motherName: ['', Validators.required],
            fatherName: ['', Validators.required],
            lastName: ['', Validators.required],
            userId: ['', Validators.required],
            dateOfBirth: ['', Validators.required],
            placeOfBirth: ['', Validators.required],
            age: ['', Validators.required],
            hobbies: ['', Validators.required],
            localAddress: ['', Validators.required],
            permanentAddress: ['', Validators.required],
            mobileNo: ['', Validators.required],
            sscScore: ['', Validators.required],
            stateId: ['', Validators.required],
            cityId: ['', Validators.required],
            departmentId: ['', Validators.required],
            gender: ['', Validators.required]

        });

    }

    onSubmitRegistration(form: FormGroup) {
        console.log("Inside registration")
        // console.log("Gender is---", this.radioOptionForGender);
        // console.log("State is---", this.selectedStateId);
        // console.log("City is---", this.selectedCityId);
        // console.log("Dept is-------", this.selectedDeptId);
        console.log("Form is--------",form);
        console.log("Form is--------",form.value);

        // this.registrationVO.firstName = form.value.firstName;
        // this.registrationVO.motherName = form.value.motherName;
        // this.registrationVO.fatherName= form.value.fatherName;
        // this.registrationVO.lastName= form.value.lastName;
        // this.registrationVO.userId= form.value.userName;
        // this.registrationVO.dateOfBirth= form.value.dob;
        // this.registrationVO.placeOfBirth= form.value.placeOfBirth;
        // this.registrationVO.age= form.value.age;
        // this.registrationVO.hobbies= form.value.hobbies;
        // this.registrationVO.localAddress= form.value.localAddr;
        // this.registrationVO.permanentAddress= form.value.perAdddr;
        // this.registrationVO.mobileNo= form.value.mobNo;
        // this.registrationVO.sscScore= form.value.sscScore;
        // this.registrationVO.gender = this.radioOptionForGender;
        // this.registrationVO.stateId= this.selectedStateId;
        // this.registrationVO.cityId = this.selectedCityId;
        // this.registrationVO.departmentId = this.selectedDeptId;
        console.log("Student data is---",this.registrationVO);

        const promise = this.httpClient.post('http://localhost:8180/StudentManagement-0.0.1-SNAPSHOT/api/main/saveStudent',form.value);
        promise.subscribe(
            data=>{
                console.log(data);
                console.log("success");
            }
        )
        

    }
}