using DotNetBackend.DTOs.Invoice;
using DotNetBackend.DTOs.Mail;
using DotNetBackend.Services.Implementations;
using DotNetBackend.Services.Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace DotNetBackend.Controllers
{
    [ApiController]
    [Route("api/invoice")]
    [Authorize]
    public class InvoiceController : ControllerBase
    {
        private readonly IInvoiceService _invoiceService;
        private readonly IMailClientService _mailClientService;

        public InvoiceController(IInvoiceService invoiceService, IMailClientService mailClientService)
        {
            _invoiceService = invoiceService;
            _mailClientService = mailClientService;
        }

        /// <summary>
        /// Generate a new Invoice
        /// </summary>
        [HttpPost("generate")]
        public IActionResult GenerateInvoice([FromBody] InvoiceRequestDto request)
        {
            try
            {
                var result = _invoiceService.GenerateInvoice(request);

                return Ok(result);
            }
            catch (Exception ex)
            {
                return BadRequest(new
                {
                    Message = ex.Message
                });
            }
        }

        /// <summary>
        /// Get Invoice By Id
        /// </summary>
        [HttpGet("{invoiceId:long}")]
        public IActionResult GetInvoice(long invoiceId)
        {
            try
            {
                var result = _invoiceService.GetInvoice(invoiceId);

                return Ok(result);
            }
            catch (Exception ex)
            {
                return NotFound(new
                {
                    Message = ex.Message
                });
            }
        }

        [HttpPost("send-mail")]
        public async Task<IActionResult> SendInvoiceMail(
    [FromBody] MailRequestDto request)
        {
            try
            {
                await _mailClientService.SendInvoiceAsync(request);

                return Ok(new
                {
                    Message = "Mail Sent Successfully"
                });
            }
            catch (Exception ex)
            {
                return BadRequest(new
                {
                    Message = ex.Message
                });
            }
        }
    }
}