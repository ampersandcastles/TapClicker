

class CounterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = 0 // Initialize the count variable

        // Update the counter value on the screen
        binding.textViewCounterValue.text = count.toString()

        // Set up click listeners for the buttons
        binding.buttonIncrement.setOnClickListener {
            count++
            binding.textViewCounterValue.text = count.toString()
        }

        binding.buttonDecrement.setOnClickListener {
            count--
            binding.textViewCounterValue.text = count.toString()
        }

        binding.buttonReset.setOnClickListener {
            count = 0
            binding.textViewCounterValue.text = count.toString()
        }
    }
}
