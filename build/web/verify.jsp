<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP VERIFICATION PAGE</title>

    <!-- Tailwind CSS -->
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet" />
    <!-- Alpine.js -->
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.7.3/dist/alpine.min.js" defer></script>
</head>

<body>
    <p style="margin-top: 30px; text-align: center;">Just wait a minute. The OTP code is being sent to <strong>${sessionScope.AUTHCODE.email}</strong>  
        <br> Check your email <a href="https://mail.google.com" target="_blank"><strong>here</strong></a> and press OTP to active your account.</p>
    <div class="py-6 px-6 w-80 border mx-auto text-center my-6">
        <form action="MainController" x-data="otpForm()" method="POST">
            <div class="flex justify-between">
                <template x-for="(input, index) in length" :key="index">
                    <input type="tel" maxlength="1" class="border border-gray-500 w-10 h-10 text-center" :x-ref="index"
                        x-on:input="handleInput($event)" x-on:paste="handlePaste($event)"
                        x-on:keydown.backspace="$event.target.value || handleBackspace($event.target.getAttribute('x-ref'))" />
                </template>
            </div>
            <input type="hidden" name="otp" x-model="value">
            <button type="submit" name="action" value="Verify" class="btn-primary mx-auto block bg-gray-500 w-full p-2 mt-2 text-white">
                Verify OTP!
            </button>
            <p style="color: red; text-align: center">${requestScope.ERROR}</p>
        </form>
    </div>
    <script>
        function otpForm() {
            return {
                length: 6,
                value: "",

                handleInput(e) {
                    const input = e.target;

                    this.value = Array.from(Array(this.length), (element, i) => {
                        return this.$refs[i].value || "";
                    }).join("");

                    if (input.nextElementSibling && input.value) {
                        input.nextElementSibling.focus();
                        input.nextElementSibling.select();
                    }
                },

                handlePaste(e) {
                    const paste = e.clipboardData.getData('text');
                    this.value = paste;

                    const inputs = Array.from(Array(this.length));

                    inputs.forEach((element, i) => {
                        this.$refs[i].value = paste[i] || '';
                    });
                },

                handleBackspace(e) {
                    const previous = parseInt(e, 10) - 1;
                    this.$refs[previous] && this.$refs[previous].focus();
                },
            };
        }
    </script>
</body>
</html>