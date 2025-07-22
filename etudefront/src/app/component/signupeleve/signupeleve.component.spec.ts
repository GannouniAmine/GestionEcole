import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupeleveComponent } from './signupeleve.component';

describe('SignupeleveComponent', () => {
  let component: SignupeleveComponent;
  let fixture: ComponentFixture<SignupeleveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SignupeleveComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SignupeleveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
